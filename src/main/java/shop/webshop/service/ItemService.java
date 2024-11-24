package shop.webshop.service;

import org.springframework.stereotype.Service;
import shop.webshop.model.Item;
import shop.webshop.repository.ItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    // Konstruktor für ItemService mit ItemRepository
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // Artikel erstellen
    public Item createItem(Item item) {
        // Speichert einen neuen Artikel in der Datenbank
        return itemRepository.save(item);
    }

    // Artikel anhand der ID abrufen
    public Optional<Item> getItemById(Long id) {
        // Gibt einen Artikel anhand der ID zurück, falls vorhanden
        return itemRepository.findById(id);
    }

    // Alle Artikel abrufen
    public List<Item> getAllItems() {
        // Gibt eine Liste aller Artikel zurück
        return itemRepository.findAll();
    }

    // Artikel aktualisieren
    public Item updateItem(Long id, Item updatedItem) {
        // Sucht den existierenden Artikel nach der ID
        Optional<Item> existingItem = itemRepository.findById(id);
        if (existingItem.isPresent()) {
            // Aktualisiert die Felder des Artikels
            Item item = existingItem.get();
            item.setName(updatedItem.getName());
            item.setQuantity(updatedItem.getQuantity());
            item.setPrice(updatedItem.getPrice());
            return itemRepository.save(item);
        } else {
            throw new RuntimeException("Artikel mit ID " + id + " nicht gefunden");
        }
    }

    // Artikel löschen
    public void deleteItem(Long id) {
        // Überprüft, ob der Artikel existiert und löscht ihn
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
        } else {
            throw new RuntimeException("Artikel mit ID " + id + " nicht gefunden");
        }
    }
}
