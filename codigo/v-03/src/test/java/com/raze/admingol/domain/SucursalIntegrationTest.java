package com.raze.admingol.domain;
import com.raze.admingol.repository.domain.SucursalRepository;
import com.raze.admingol.service.domain.SucursalService;
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
public class SucursalIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    SucursalDataOnDemand dod;

	@Autowired
    SucursalService sucursalService;

	@Autowired
    SucursalRepository sucursalRepository;

	@Test
    public void testCountAllSucursals() {
        Assert.assertNotNull("Data on demand for 'Sucursal' failed to initialize correctly", dod.getRandomSucursal());
        long count = sucursalService.countAllSucursals();
        Assert.assertTrue("Counter for 'Sucursal' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindSucursal() {
        Sucursal obj = dod.getRandomSucursal();
        Assert.assertNotNull("Data on demand for 'Sucursal' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Sucursal' failed to provide an identifier", id);
        obj = sucursalService.findSucursal(id);
        Assert.assertNotNull("Find method for 'Sucursal' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Sucursal' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllSucursals() {
        Assert.assertNotNull("Data on demand for 'Sucursal' failed to initialize correctly", dod.getRandomSucursal());
        long count = sucursalService.countAllSucursals();
        Assert.assertTrue("Too expensive to perform a find all test for 'Sucursal', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Sucursal> result = sucursalService.findAllSucursals();
        Assert.assertNotNull("Find all method for 'Sucursal' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Sucursal' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindSucursalEntries() {
        Assert.assertNotNull("Data on demand for 'Sucursal' failed to initialize correctly", dod.getRandomSucursal());
        long count = sucursalService.countAllSucursals();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Sucursal> result = sucursalService.findSucursalEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Sucursal' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Sucursal' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testFlush() {
        Sucursal obj = dod.getRandomSucursal();
        Assert.assertNotNull("Data on demand for 'Sucursal' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Sucursal' failed to provide an identifier", id);
        obj = sucursalService.findSucursal(id);
        Assert.assertNotNull("Find method for 'Sucursal' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifySucursal(obj);
        Integer currentVersion = obj.getVersion();
        sucursalRepository.flush();
        Assert.assertTrue("Version for 'Sucursal' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testUpdateSucursalUpdate() {
        Sucursal obj = dod.getRandomSucursal();
        Assert.assertNotNull("Data on demand for 'Sucursal' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Sucursal' failed to provide an identifier", id);
        obj = sucursalService.findSucursal(id);
        boolean modified =  dod.modifySucursal(obj);
        Integer currentVersion = obj.getVersion();
        Sucursal merged = sucursalService.updateSucursal(obj);
        sucursalRepository.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'Sucursal' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testSaveSucursal() {
        Assert.assertNotNull("Data on demand for 'Sucursal' failed to initialize correctly", dod.getRandomSucursal());
        Sucursal obj = dod.getNewTransientSucursal(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Sucursal' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Sucursal' identifier to be null", obj.getId());
        try {
            sucursalService.saveSucursal(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        sucursalRepository.flush();
        Assert.assertNotNull("Expected 'Sucursal' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testDeleteSucursal() {
        Sucursal obj = dod.getRandomSucursal();
        Assert.assertNotNull("Data on demand for 'Sucursal' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Sucursal' failed to provide an identifier", id);
        obj = sucursalService.findSucursal(id);
        sucursalService.deleteSucursal(obj);
        sucursalRepository.flush();
        Assert.assertNull("Failed to remove 'Sucursal' with identifier '" + id + "'", sucursalService.findSucursal(id));
    }
}
