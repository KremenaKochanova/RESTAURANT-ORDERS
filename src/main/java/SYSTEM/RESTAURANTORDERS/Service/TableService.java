package SYSTEM.RESTAURANTORDERS.Service;

import org.springframework.stereotype.Service;

@Service
public class TableService {
    private final TableRepository tableRepository;

    public TableService(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    public Table saveTable(Table table) {
        return tableRepository.save(table);
    }

    public List<Table> getAllTables() {
        return tableRepository.findAll();
    }

    public Table getTableById(Long id) {
        return tableRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Table not found"));
    }

    public void deleteTable(Long id) {
        tableRepository.deleteById(id);
    }

    public List<Table> getFreeTables() {
        return tableRepository.findByStatus(TableStatus.FREE);
    }
}
