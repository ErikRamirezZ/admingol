package com.raze.admingol.domain;
import com.raze.admingol.repository.domain.PartidoRepository;
import com.raze.admingol.service.domain.PartidoService;
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
public class PartidoIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    PartidoDataOnDemand dod;

	@Autowired
    PartidoService partidoService;

	@Autowired
    PartidoRepository partidoRepository;

	@Test
    public void testCountAllPartidoes() {
        Assert.assertNotNull("Data on demand for 'Partido' failed to initialize correctly", dod.getRandomPartido());
        long count = partidoService.countAllPartidoes();
        Assert.assertTrue("Counter for 'Partido' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindPartido() {
        Partido obj = dod.getRandomPartido();
        Assert.assertNotNull("Data on demand for 'Partido' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Partido' failed to provide an identifier", id);
        obj = partidoService.findPartido(id);
        Assert.assertNotNull("Find method for 'Partido' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Partido' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllPartidoes() {
        Assert.assertNotNull("Data on demand for 'Partido' failed to initialize correctly", dod.getRandomPartido());
        long count = partidoService.countAllPartidoes();
        Assert.assertTrue("Too expensive to perform a find all test for 'Partido', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Partido> result = partidoService.findAllPartidoes();
        Assert.assertNotNull("Find all method for 'Partido' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Partido' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindPartidoEntries() {
        Assert.assertNotNull("Data on demand for 'Partido' failed to initialize correctly", dod.getRandomPartido());
        long count = partidoService.countAllPartidoes();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Partido> result = partidoService.findPartidoEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Partido' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Partido' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testFlush() {
        Partido obj = dod.getRandomPartido();
        Assert.assertNotNull("Data on demand for 'Partido' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Partido' failed to provide an identifier", id);
        obj = partidoService.findPartido(id);
        Assert.assertNotNull("Find method for 'Partido' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyPartido(obj);
        Integer currentVersion = obj.getVersion();
        partidoRepository.flush();
        Assert.assertTrue("Version for 'Partido' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testUpdatePartidoUpdate() {
        Partido obj = dod.getRandomPartido();
        Assert.assertNotNull("Data on demand for 'Partido' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Partido' failed to provide an identifier", id);
        obj = partidoService.findPartido(id);
        boolean modified =  dod.modifyPartido(obj);
        Integer currentVersion = obj.getVersion();
        Partido merged = partidoService.updatePartido(obj);
        partidoRepository.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'Partido' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testSavePartido() {
        Assert.assertNotNull("Data on demand for 'Partido' failed to initialize correctly", dod.getRandomPartido());
        Partido obj = dod.getNewTransientPartido(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Partido' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Partido' identifier to be null", obj.getId());
        try {
            partidoService.savePartido(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        partidoRepository.flush();
        Assert.assertNotNull("Expected 'Partido' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testDeletePartido() {
        Partido obj = dod.getRandomPartido();
        Assert.assertNotNull("Data on demand for 'Partido' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Partido' failed to provide an identifier", id);
        obj = partidoService.findPartido(id);
        partidoService.deletePartido(obj);
        partidoRepository.flush();
        Assert.assertNull("Failed to remove 'Partido' with identifier '" + id + "'", partidoService.findPartido(id));
    }
}
