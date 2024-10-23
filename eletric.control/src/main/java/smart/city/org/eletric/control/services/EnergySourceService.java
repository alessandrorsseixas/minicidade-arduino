package smart.city.org.eletric.control.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smart.city.org.eletric.control.entities.EnergySource;
import smart.city.org.eletric.control.exceptions.ResourceNotFoundException;
import smart.city.org.eletric.control.repositories.EneregySourcesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EnergySourceService {

    @Autowired
    private EneregySourcesRepository eneregySourcesRepository;

    public List<EnergySource> findAll() { return eneregySourcesRepository.findAll();}

    public EnergySource create(EnergySource energySource) { return eneregySourcesRepository.save(energySource);}

    public EnergySource findById(String id) throws ResourceNotFoundException {

        Optional<EnergySource> energySource = eneregySourcesRepository.findById(id);

        if(energySource.isEmpty()) {
          throw new ResourceNotFoundException("Energy Source com " + id + "não foi encontrado");
        }
        return energySource.get();
    }

    public boolean existsById (String id){
        return  eneregySourcesRepository.existsById(id);
    }

    public void deleteById(String id){

        eneregySourcesRepository.deleteById(id);

    }
    public void delete(EnergySource energySource){
            eneregySourcesRepository.delete(energySource);

    }

}
