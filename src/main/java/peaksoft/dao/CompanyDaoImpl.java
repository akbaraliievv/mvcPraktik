package peaksoft.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import peaksoft.model.Company;

import java.util.List;
@Repository
@Transactional
public class CompanyDaoImpl implements CompanyDao{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void save(Company company) {
        entityManager.persist(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        return entityManager.createQuery("select c from Company c ", Company.class).getResultList();
    }

    @Override
    public Company getCompanyById(Long id) {
        return null;
    }

    @Override
    public void deleteCompany(Long id) {
        entityManager.remove(entityManager.find(Company.class,id));
    }

    @Override
    public void updateCompany(Long id, Company updatedCompany) {

    }
}
