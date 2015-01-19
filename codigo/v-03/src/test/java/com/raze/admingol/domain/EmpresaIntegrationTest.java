package com.raze.admingol.domain;
import com.raze.admingol.repository.domain.EmpresaRepository;
import com.raze.admingol.service.domain.EmpresaService;
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
public class EmpresaIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    EmpresaDataOnDemand dod;

	@Autowired
    EmpresaService empresaService;

	@Autowired
    EmpresaRepository empresaRepository;

	@Test
    public void testCountAllEmpresas() {
        Assert.assertNotNull("Data on demand for 'Empresa' failed to initialize correctly", dod.getRandomEmpresa());
        long count = empresaService.countAllEmpresas();
        Assert.assertTrue("Counter for 'Empresa' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindEmpresa() {
        Empresa obj = dod.getRandomEmpresa();
        Assert.assertNotNull("Data on demand for 'Empresa' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Empresa' failed to provide an identifier", id);
        obj = empresaService.findEmpresa(id);
        Assert.assertNotNull("Find method for 'Empresa' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Empresa' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllEmpresas() {
        Assert.assertNotNull("Data on demand for 'Empresa' failed to initialize correctly", dod.getRandomEmpresa());
        long count = empresaService.countAllEmpresas();
        Assert.assertTrue("Too expensive to perform a find all test for 'Empresa', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Empresa> result = empresaService.findAllEmpresas();
        Assert.assertNotNull("Find all method for 'Empresa' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Empresa' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindEmpresaEntries() {
        Assert.assertNotNull("Data on demand for 'Empresa' failed to initialize correctly", dod.getRandomEmpresa());
        long count = empresaService.countAllEmpresas();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Empresa> result = empresaService.findEmpresaEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Empresa' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Empresa' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testFlush() {
        Empresa obj = dod.getRandomEmpresa();
        Assert.assertNotNull("Data on demand for 'Empresa' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Empresa' failed to provide an identifier", id);
        obj = empresaService.findEmpresa(id);
        Assert.assertNotNull("Find method for 'Empresa' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyEmpresa(obj);
        Integer currentVersion = obj.getVersion();
        empresaRepository.flush();
        Assert.assertTrue("Version for 'Empresa' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testUpdateEmpresaUpdate() {
        Empresa obj = dod.getRandomEmpresa();
        Assert.assertNotNull("Data on demand for 'Empresa' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Empresa' failed to provide an identifier", id);
        obj = empresaService.findEmpresa(id);
        boolean modified =  dod.modifyEmpresa(obj);
        Integer currentVersion = obj.getVersion();
        Empresa merged = empresaService.updateEmpresa(obj);
        empresaRepository.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'Empresa' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testSaveEmpresa() {
        Assert.assertNotNull("Data on demand for 'Empresa' failed to initialize correctly", dod.getRandomEmpresa());
        Empresa obj = dod.getNewTransientEmpresa(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Empresa' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Empresa' identifier to be null", obj.getId());
        try {
            empresaService.saveEmpresa(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        empresaRepository.flush();
        Assert.assertNotNull("Expected 'Empresa' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testDeleteEmpresa() {
        Empresa obj = dod.getRandomEmpresa();
        Assert.assertNotNull("Data on demand for 'Empresa' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Empresa' failed to provide an identifier", id);
        obj = empresaService.findEmpresa(id);
        empresaService.deleteEmpresa(obj);
        empresaRepository.flush();
        Assert.assertNull("Failed to remove 'Empresa' with identifier '" + id + "'", empresaService.findEmpresa(id));
    }
}
