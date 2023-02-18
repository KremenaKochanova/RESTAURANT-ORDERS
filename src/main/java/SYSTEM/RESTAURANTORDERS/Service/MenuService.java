package SYSTEM.RESTAURANTORDERS.Service;

import org.springframework.stereotype.Service;

@Service
public class MenuService {
    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public Menu saveMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Menu getMenuById(Long id) {
        return menuRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Menu not found"));
    }

    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }

    public List<Menu> getMenusByType(String type) {
        return menuRepository.findByType(type);
    }
}
