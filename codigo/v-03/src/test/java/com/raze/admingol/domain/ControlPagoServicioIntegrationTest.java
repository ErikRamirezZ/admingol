package com.raze.admingol.domain;
import com.raze.admingol.repository.domain.ControlPagoServicioRepository;
import com.raze.admingol.service.domain.ControlPagoServicioService;
import java.util.Iterator;
import java.util.List;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@Configurable
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext*.xml")
@Transactional
public class ControlPagoServicioIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    ControlPagoServicioDataOnDemand dod;

	@Autowired
    ControlPagoServicioService controlPagoServicioService;

	@Autowired
    ControlPagoServicioRepository controlPagoServicioRepository;

	@Test
    public void testCountAllControlPagoServicios() {
        Assert.assertNotNull("Data on demand for 'ControlPagoServicio' failed to initialize correctly", dod.getRandomControlPagoServicio());
        long count = controlPagoServicioService.countAllControlPagoServicios();
        Assert.assertTrue("Counter for 'ControlPagoServicio' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindControlPagoServicio() {
        ControlPagoServicio obj = dod.getRandomControlPagoServicio();
        Assert.assertNotNull("Data on demand for 'ControlPagoServicio' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'ControlPagoServicio' failed to provide an identifier", id);
        obj = controlPagoServicioService.findControlPagoServicio(id);
        Assert.assertNotNull("Find method for 'ControlPagoServicio' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'ControlPagoServicio' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllControlPagoServicios() {
        Assert.assertNotNull("Data on demand for 'ControlPagoServicio' failed to initialize correctly", dod.getRandomControlPagoServicio());
        long count = controlPagoServicioService.countAllControlPagoServicios();
        Assert.assertTrue("Too expensive to perform a find all test for 'ControlPagoServicio', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<ControlPagoServicio> result = controlPagoServicioService.findAllControlPagoServicios();
        Assert.assertNotNull("Find all method for 'ControlPagoServicio' illegally returned null", result);
        Assert.assertTrue("Find all method for 'ControlPagoServicio' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindControlPagoServicioEntries() {
        Assert.assertNotNull("Data on demand for 'ControlPagoServicio' failed to initialize correctly", dod.getRandomControlPagoServicio());
        long count = controlPagoServicioService.countAllControlPagoServicios();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<ControlPagoServicio> result = controlPagoServicioService.findControlPagoServicioEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'ControlPagoServicio' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'ControlPagoServicio' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testFlush() {
        ControlPagoServicio obj = dod.getRandomControlPagoServicio();
        Assert.assertNotNull("Data on demand for 'ControlPagoServicio' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'ControlPagoServicio' failed to provide an identifier", id);
        obj = controlPagoServicioService.findControlPagoServicio(id);
        Assert.assertNotNull("Find method for 'ControlPagoServicio' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyControlPagoServicio(obj);
        Integer currentVersion = obj.getVersion();
        controlPagoServicioRepository.flush();
        Assert.assertTrue("Version for 'ControlPagoServicio' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testUpdateControlPagoServicioUpdate() {
        ControlPagoServicio obj = dod.getRandomControlPagoServicio();
        Assert.assertNotNull("Data on demand for 'ControlPagoServicio' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'ControlPagoServicio' failed to provide an identifier", id);
        obj = controlPagoServicioService.findControlPagoServicio(id);
        boolean modified =  dod.modifyControlPagoServicio(obj);
        Integer currentVersion = obj.getVersion();
        ControlPagoServicio merged = controlPagoServicioService.updateControlPagoServicio(obj);
        controlPagoServicioRepository.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'ControlPagoServicio' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testSaveControlPagoServicio() {
        Assert.assertNotNull("Data on demand for 'ControlPagoServicio' failed to initialize correctly", dod.getRandomControlPagoServicio());
        ControlPagoServicio obj = dod.getNewTransientControlPagoServicio(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'ControlPagoServicio' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'ControlPagoServicio' identifier to be null", obj.getId());
        try {
            controlPagoServicioService.saveControlPagoServicio(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        controlPagoServicioRepository.flush();
        Assert.assertNotNull("Expected 'ControlPagoServicio' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testDeleteControlPagoServicio() {
        ControlPagoServicio obj = dod.getRandomControlPagoServicio();
        Assert.assertNotNull("Data on demand for 'ControlPagoServicio' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'ControlPagoServicio' failed to provide an identifier", id);
        obj = controlPagoServicioService.findControlPagoServicio(id);
        controlPagoServicioService.deleteControlPagoServicio(obj);
        controlPagoServicioRepository.flush();
        Assert.assertNull("Failed to remove 'ControlPagoServicio' with identifier '" + id + "'", controlPagoServicioService.findControlPagoServicio(id));
    }
}
