package com.raze.admingol.domain;
import com.raze.admingol.repository.domain.PagoHechoServicioRepository;
import com.raze.admingol.service.domain.PagoHechoServicioService;
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
@RooIntegrationTest(entity = PagoHechoServicio.class)
public class PagoHechoServicioIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    PagoHechoServicioDataOnDemand dod;

	@Autowired
    PagoHechoServicioService pagoHechoServicioService;

	@Autowired
    PagoHechoServicioRepository pagoHechoServicioRepository;

	@Test
    public void testCountAllPagoHechoServicios() {
        Assert.assertNotNull("Data on demand for 'PagoHechoServicio' failed to initialize correctly", dod.getRandomPagoHechoServicio());
        long count = pagoHechoServicioService.countAllPagoHechoServicios();
        Assert.assertTrue("Counter for 'PagoHechoServicio' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindPagoHechoServicio() {
        PagoHechoServicio obj = dod.getRandomPagoHechoServicio();
        Assert.assertNotNull("Data on demand for 'PagoHechoServicio' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'PagoHechoServicio' failed to provide an identifier", id);
        obj = pagoHechoServicioService.findPagoHechoServicio(id);
        Assert.assertNotNull("Find method for 'PagoHechoServicio' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'PagoHechoServicio' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllPagoHechoServicios() {
        Assert.assertNotNull("Data on demand for 'PagoHechoServicio' failed to initialize correctly", dod.getRandomPagoHechoServicio());
        long count = pagoHechoServicioService.countAllPagoHechoServicios();
        Assert.assertTrue("Too expensive to perform a find all test for 'PagoHechoServicio', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<PagoHechoServicio> result = pagoHechoServicioService.findAllPagoHechoServicios();
        Assert.assertNotNull("Find all method for 'PagoHechoServicio' illegally returned null", result);
        Assert.assertTrue("Find all method for 'PagoHechoServicio' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindPagoHechoServicioEntries() {
        Assert.assertNotNull("Data on demand for 'PagoHechoServicio' failed to initialize correctly", dod.getRandomPagoHechoServicio());
        long count = pagoHechoServicioService.countAllPagoHechoServicios();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<PagoHechoServicio> result = pagoHechoServicioService.findPagoHechoServicioEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'PagoHechoServicio' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'PagoHechoServicio' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testFlush() {
        PagoHechoServicio obj = dod.getRandomPagoHechoServicio();
        Assert.assertNotNull("Data on demand for 'PagoHechoServicio' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'PagoHechoServicio' failed to provide an identifier", id);
        obj = pagoHechoServicioService.findPagoHechoServicio(id);
        Assert.assertNotNull("Find method for 'PagoHechoServicio' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyPagoHechoServicio(obj);
        Integer currentVersion = obj.getVersion();
        pagoHechoServicioRepository.flush();
        Assert.assertTrue("Version for 'PagoHechoServicio' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testUpdatePagoHechoServicioUpdate() {
        PagoHechoServicio obj = dod.getRandomPagoHechoServicio();
        Assert.assertNotNull("Data on demand for 'PagoHechoServicio' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'PagoHechoServicio' failed to provide an identifier", id);
        obj = pagoHechoServicioService.findPagoHechoServicio(id);
        boolean modified =  dod.modifyPagoHechoServicio(obj);
        Integer currentVersion = obj.getVersion();
        PagoHechoServicio merged = pagoHechoServicioService.updatePagoHechoServicio(obj);
        pagoHechoServicioRepository.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'PagoHechoServicio' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testSavePagoHechoServicio() {
        Assert.assertNotNull("Data on demand for 'PagoHechoServicio' failed to initialize correctly", dod.getRandomPagoHechoServicio());
        PagoHechoServicio obj = dod.getNewTransientPagoHechoServicio(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'PagoHechoServicio' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'PagoHechoServicio' identifier to be null", obj.getId());
        try {
            pagoHechoServicioService.savePagoHechoServicio(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        pagoHechoServicioRepository.flush();
        Assert.assertNotNull("Expected 'PagoHechoServicio' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testDeletePagoHechoServicio() {
        PagoHechoServicio obj = dod.getRandomPagoHechoServicio();
        Assert.assertNotNull("Data on demand for 'PagoHechoServicio' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'PagoHechoServicio' failed to provide an identifier", id);
        obj = pagoHechoServicioService.findPagoHechoServicio(id);
        pagoHechoServicioService.deletePagoHechoServicio(obj);
        pagoHechoServicioRepository.flush();
        Assert.assertNull("Failed to remove 'PagoHechoServicio' with identifier '" + id + "'", pagoHechoServicioService.findPagoHechoServicio(id));
    }
}
