package SYSTEM.RESTAURANTORDERS.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public ResponseEntity<List<MenuItemDto>> getMenu() {
        List<MenuItemDto> menuItems = menuService.getMenuItems();
        return ResponseEntity.ok(menuItems);
    }

    @PostMapping
    public ResponseEntity<MenuItemDto> addMenuItem(@RequestBody MenuItemDto menuItemDto) {
        MenuItemDto addedMenuItem = menuService.addMenuItem(menuItemDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedMenuItem);
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<MenuItemDto> updateMenuItem(@PathVariable Long itemId, @RequestBody MenuItemDto menuItemDto) {
        MenuItemDto updatedMenuItem = menuService.updateMenuItem(itemId, menuItemDto);
        return ResponseEntity.ok(updatedMenuItem);
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteMenuItem(@PathVariable Long itemId) {
        menuService.deleteMenuItem(itemId);
        return ResponseEntity.noContent().build();
    }
}

