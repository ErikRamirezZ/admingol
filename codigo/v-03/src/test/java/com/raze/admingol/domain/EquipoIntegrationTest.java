package com.raze.admingol.domain;
import com.raze.admingol.repository.domain.EquipoRepository;
import com.raze.admingol.service.domain.EquipoService;
import java.util.Iterator;
import java.util.List;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.roo.addon.test.RooIntegrationTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext*.xml")
@Transactional
@Configurable
@RooIntegrationTest(entity = Equipo.class)
public class EquipoIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    EquipoDataOnDemand dod;

	@Autowired
    EquipoService equipoService;

	@Autowired
    EquipoRepository equipoRepository;

	@Test
    public void testCountAllEquipoes() {
        Assert.assertNotNull("Data on demand for 'Equipo' failed to initialize correctly", dod.getRandomEquipo());
        long count = equipoService.countAllEquipoes();
        Assert.assertTrue("Counter for 'Equipo' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindEquipo() {
        Equipo obj = dod.getRandomEquipo();
        Assert.assertNotNull("Data on demand for 'Equipo' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Equipo' failed to provide an identifier", id);
        obj = equipoService.findEquipo(id);
        Assert.assertNotNull("Find method for 'Equipo' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Equipo' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllEquipoes() {
        Assert.assertNotNull("Data on demand for 'Equipo' failed to initialize correctly", dod.getRandomEquipo());
        long count = equipoService.countAllEquipoes();
        Assert.assertTrue("Too expensive to perform a find all test for 'Equipo', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Equipo> result = equipoService.findAllEquipoes();
        Assert.assertNotNull("Find all method for 'Equipo' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Equipo' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindEquipoEntries() {
        Assert.assertNotNull("Data on demand for 'Equipo' failed to initialize correctly", dod.getRandomEquipo());
        long count = equipoService.countAllEquipoes();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Equipo> result = equipoService.findEquipoEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Equipo' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Equipo' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testFlush() {
        Equipo obj = dod.getRandomEquipo();
        Assert.assertNotNull("Data on demand for 'Equipo' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Equipo' failed to provide an identifier", id);
        obj = equipoService.findEquipo(id);
        Assert.assertNotNull("Find method for 'Equipo' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyEquipo(obj);
        Integer currentVersion = obj.getVersion();
        equipoRepository.flush();
        Assert.assertTrue("Version for 'Equipo' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testUpdateEquipoUpdate() {
        Equipo obj = dod.getRandomEquipo();
        Assert.assertNotNull("Data on demand for 'Equipo' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Equipo' failed to provide an identifier", id);
        obj = equipoService.findEquipo(id);
        boolean modified =  dod.modifyEquipo(obj);
        Integer currentVersion = obj.getVersion();
        Equipo merged = equipoService.updateEquipo(obj);
        equipoRepository.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'Equipo' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testSaveEquipo() {
        Assert.assertNotNull("Data on demand for 'Equipo' failed to initialize correctly", dod.getRandomEquipo());
        Equipo obj = dod.getNewTransientEquipo(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Equipo' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Equipo' identifier to be null", obj.getId());
        try {
            equipoService.saveEquipo(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        equipoRepository.flush();
        Assert.assertNotNull("Expected 'Equipo' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testDeleteEquipo() {
        Equipo obj = dod.getRandomEquipo();
        Assert.assertNotNull("Data on demand for 'Equipo' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Equipo' failed to provide an identifier", id);
        obj = equipoService.findEquipo(id);
        equipoService.deleteEquipo(obj);
        equipoRepository.flush();
        Assert.assertNull("Failed to remove 'Equipo' with identifier '" + id + "'", equipoService.findEquipo(id));
    }
}
