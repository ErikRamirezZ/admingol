package com.raze.admingol.domain;
import com.raze.admingol.repository.domain.RolRepository;
import com.raze.admingol.service.domain.RolService;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

@Component
@Configurable
public class RolDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<Rol> data;

	@Autowired
    RolService rolService;

	@Autowired
    RolRepository rolRepository;

	public Rol getNewTransientRol(int index) {
        Rol obj = new Rol();
        return obj;
    }

	public Rol getSpecificRol(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Rol obj = data.get(index);
        Long id = obj.getId();
        return rolService.findRol(id);
    }

	public Rol getRandomRol() {
        init();
        Rol obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return rolService.findRol(id);
    }

	public boolean modifyRol(Rol obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = rolService.findRolEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Rol' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Rol>();
        for (int i = 0; i < 10; i++) {
            Rol obj = getNewTransientRol(i);
            try {
                rolService.saveRol(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            rolRepository.flush();
            data.add(obj);
        }
    }
}
