-- Insert test clients
INSERT INTO client (identifiant, date_premiere_visite) 
VALUES ('CLI001', '2024-01-01'),
       ('CLI002', '2024-02-01');

-- Insert test menus
INSERT INTO menu (libelle_menu, type_menu, prix_total) 
VALUES ('Menu Express', 'DEJEUNER', 15.0),
       ('Menu Gourmet', 'DINER', 18.0);

-- Insert test commandes for different dates in 2024
INSERT INTO commande (date_commande, pourcentage_remise, total_remise, total_commande, note, client_id_client, menu_id_menu)
VALUES 
-- Recent commands
('2024-03-15', 10, 1.5, 13.5, 4, 1, 1),
('2024-03-16', 0, 0, 15.0, 5, 1, 1),
('2024-03-17', 5, 0.9, 17.1, 3, 2, 2),

-- Older commands from this year
('2024-01-10', 0, 0, 15.0, 4, 1, 1),
('2024-02-15', 10, 1.8, 16.2, 5, 2, 2),

-- Last year's commands (shouldn't appear in results)
('2023-12-15', 0, 0, 15.0, 4, 1, 1),
('2023-12-20', 5, 0.9, 17.1, 3, 2, 2);
