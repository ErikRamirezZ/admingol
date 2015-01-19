package com.raze.admingol.domain;
import com.raze.admingol.repository.domain.ConfiguracionNotificacionesRepository;
import com.raze.admingol.service.domain.ConfiguracionNotificacionesService;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext*.xml")
@Transactional
@Configurable
public class ConfiguracionNotificacionesIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    ConfiguracionNotificacionesDataOnDemand dod;

	@Autowired
    ConfiguracionNotificacionesService configuracionNotificacionesService;

	@Autowired
    ConfiguracionNotificacionesRepository configuracionNotificacionesRepository;

	@Test
    public void testCountAllConfiguracionNotificacioneses() {
        Assert.assertNotNull("Data on demand for 'ConfiguracionNotificaciones' failed to initialize correctly", dod.getRandomConfiguracionNotificaciones());
        long count = configuracionNotificacionesService.countAllConfiguracionNotificacioneses();
        Assert.assertTrue("Counter for 'ConfiguracionNotificaciones' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindConfiguracionNotificaciones() {
        ConfiguracionNotificaciones obj = dod.getRandomConfiguracionNotificaciones();
        Assert.assertNotNull("Data on demand for 'ConfiguracionNotificaciones' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'ConfiguracionNotificaciones' failed to provide an identifier", id);
        obj = configuracionNotificacionesService.findConfiguracionNotificaciones(id);
        Assert.assertNotNull("Find method for 'ConfiguracionNotificaciones' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'ConfiguracionNotificaciones' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllConfiguracionNotificacioneses() {
        Assert.assertNotNull("Data on demand for 'ConfiguracionNotificaciones' failed to initialize correctly", dod.getRandomConfiguracionNotificaciones());
        long count = configuracionNotificacionesService.countAllConfiguracionNotificacioneses();
        Assert.assertTrue("Too expensive to perform a find all test for 'ConfiguracionNotificaciones', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<ConfiguracionNotificaciones> result = configuracionNotificacionesService.findAllConfiguracionNotificacioneses();
        Assert.assertNotNull("Find all method for 'ConfiguracionNotificaciones' illegally returned null", result);
        Assert.assertTrue("Find all method for 'ConfiguracionNotificaciones' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindConfiguracionNotificacionesEntries() {
        Assert.assertNotNull("Data on demand for 'ConfiguracionNotificaciones' failed to initialize correctly", dod.getRandomConfiguracionNotificaciones());
        long count = configuracionNotificacionesService.countAllConfiguracionNotificacioneses();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<ConfiguracionNotificaciones> result = configuracionNotificacionesService.findConfiguracionNotificacionesEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'ConfiguracionNotificaciones' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'ConfiguracionNotificaciones' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testFlush() {
        ConfiguracionNotificaciones obj = dod.getRandomConfiguracionNotificaciones();
        Assert.assertNotNull("Data on demand for 'ConfiguracionNotificaciones' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'ConfiguracionNotificaciones' failed to provide an identifier", id);
        obj = configuracionNotificacionesService.findConfiguracionNotificaciones(id);
        Assert.assertNotNull("Find method for 'ConfiguracionNotificaciones' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyConfiguracionNotificaciones(obj);
        Integer currentVersion = obj.getVersion();
        configuracionNotificacionesRepository.flush();
        Assert.assertTrue("Version for 'ConfiguracionNotificaciones' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testUpdateConfiguracionNotificacionesUpdate() {
        ConfiguracionNotificaciones obj = dod.getRandomConfiguracionNotificaciones();
        Assert.assertNotNull("Data on demand for 'ConfiguracionNotificaciones' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'ConfiguracionNotificaciones' failed to provide an identifier", id);
        obj = configuracionNotificacionesService.findConfiguracionNotificaciones(id);
        boolean modified =  dod.modifyConfiguracionNotificaciones(obj);
        Integer currentVersion = obj.getVersion();
        ConfiguracionNotificaciones merged = configuracionNotificacionesService.updateConfiguracionNotificaciones(obj);
        configuracionNotificacionesRepository.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'ConfiguracionNotificaciones' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testSaveConfiguracionNotificaciones() {
        Assert.assertNotNull("Data on demand for 'ConfiguracionNotificaciones' failed to initialize correctly", dod.getRandomConfiguracionNotificaciones());
        ConfiguracionNotificaciones obj = dod.getNewTransientConfiguracionNotificaciones(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'ConfiguracionNotificaciones' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'ConfiguracionNotificaciones' identifier to be null", obj.getId());
        try {
            configuracionNotificacionesService.saveConfiguracionNotificaciones(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        configuracionNotificacionesRepository.flush();
        Assert.assertNotNull("Expected 'ConfiguracionNotificaciones' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testDeleteConfiguracionNotificaciones() {
        ConfiguracionNotificaciones obj = dod.getRandomConfiguracionNotificaciones();
        Assert.assertNotNull("Data on demand for 'ConfiguracionNotificaciones' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'ConfiguracionNotificaciones' failed to provide an identifier", id);
        obj = configuracionNotificacionesService.findConfiguracionNotificaciones(id);
        configuracionNotificacionesService.deleteConfiguracionNotificaciones(obj);
        configuracionNotificacionesRepository.flush();
        Assert.assertNull("Failed to remove 'ConfiguracionNotificaciones' with identifier '" + id + "'", configuracionNotificacionesService.findConfiguracionNotificaciones(id));
    }
}
