-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 05 sep. 2020 à 01:53
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP : 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `reservationbilletsavions`
--

-- --------------------------------------------------------

--
-- Structure de la table `tadmin`
--

CREATE TABLE `tadmin` (
  `ID_Admin` int(11) NOT NULL,
  `NomAdmin` varchar(30) NOT NULL,
  `PrenomAdmin` varchar(30) NOT NULL,
  `LoginAdmin` varchar(30) DEFAULT NULL,
  `PasswordAdmin` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `tadmin`
--

INSERT INTO `tadmin` (`ID_Admin`, `NomAdmin`, `PrenomAdmin`, `LoginAdmin`, `PasswordAdmin`) VALUES
(1, 'Said', 'Elkafhali', 'said-Elkafhali@gmail.com', 'said123');

-- --------------------------------------------------------

--
-- Structure de la table `tavion`
--

CREATE TABLE `tavion` (
  `ID_Avion` int(11) NOT NULL,
  `Vitesse` double NOT NULL,
  `Autonomie` double NOT NULL,
  `NomAvion` varchar(30) NOT NULL,
  `Prix_Km_eco` double NOT NULL,
  `Prix_km_affaire` double NOT NULL,
  `Prix_km_1ere` double NOT NULL,
  `EtatAvion` varchar(30) NOT NULL,
  `NombrePlaces1ere` int(11) NOT NULL,
  `NombrePlacesEco` int(11) NOT NULL,
  `NombrePlacesAff` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `tavion`
--

INSERT INTO `tavion` (`ID_Avion`, `Vitesse`, `Autonomie`, `NomAvion`, `Prix_Km_eco`, `Prix_km_affaire`, `Prix_km_1ere`, `EtatAvion`, `NombrePlaces1ere`, `NombrePlacesEco`, `NombrePlacesAff`) VALUES
(14, 5000, 4300, 'Airbus890', 1, 1, 1, 'bonne', 100, 50, 25),
(15, 7777, 777, 'A1', 1, 1, 1, 'bonne', 100, 50, 25),
(18, 421221, 21112, 'boeing89000', 1, 1, 1, 'bonne', 100, 20, 30);

-- --------------------------------------------------------

--
-- Structure de la table `tbillet`
--

CREATE TABLE `tbillet` (
  `ID_Billet` int(11) NOT NULL,
  `ID_Reservation` int(11) NOT NULL,
  `ID_Client` int(11) NOT NULL,
  `PrixTotale` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `tbillet`
--

INSERT INTO `tbillet` (`ID_Billet`, `ID_Reservation`, `ID_Client`, `PrixTotale`) VALUES
(26, 29, 19, 94.29511739016398),
(37, 32, 20, 4371.526135731728),
(38, 33, 20, 4371.526135731728),
(51, 37, 20, 4371.526135731728),
(53, 39, 21, 4371.526135731728);

-- --------------------------------------------------------

--
-- Structure de la table `tcategorie`
--

CREATE TABLE `tcategorie` (
  `ID_Categorie` int(11) NOT NULL,
  `LibelleCategorie` varchar(30) NOT NULL,
  `PourcentageReduction` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `tcategorie`
--

INSERT INTO `tcategorie` (`ID_Categorie`, `LibelleCategorie`, `PourcentageReduction`) VALUES
(1, 'Junior', 0.4),
(2, 'Senior', 0.25),
(3, 'Vieux', 0.7);

-- --------------------------------------------------------

--
-- Structure de la table `tclasse`
--

CREATE TABLE `tclasse` (
  `ID_Classe` int(11) NOT NULL,
  `LibelleClasse` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `tclasse`
--

INSERT INTO `tclasse` (`ID_Classe`, `LibelleClasse`) VALUES
(1, '1ere'),
(2, 'Economie'),
(3, 'Affaire');

-- --------------------------------------------------------

--
-- Structure de la table `tclient`
--

CREATE TABLE `tclient` (
  `ID_Client` int(11) NOT NULL,
  `NomClient` varchar(30) DEFAULT NULL,
  `PrenomClient` varchar(30) DEFAULT NULL,
  `DateNaissance` date DEFAULT NULL,
  `CINClient` varchar(30) DEFAULT NULL,
  `NumPasseport` varchar(30) DEFAULT NULL,
  `Nationalite` varchar(30) DEFAULT NULL,
  `LoginClient` varchar(30) DEFAULT NULL,
  `PasswordClient` varchar(30) DEFAULT NULL,
  `CategorieClient` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `tclient`
--

INSERT INTO `tclient` (`ID_Client`, `NomClient`, `PrenomClient`, `DateNaissance`, `CINClient`, `NumPasseport`, `Nationalite`, `LoginClient`, `PasswordClient`, `CategorieClient`) VALUES
(1, 'dfsd', 'fvcdfsdf', '2020-06-02', '0', '11515', 'Nationalite', 'LoginClient', 'PasswordClient', 'CategorieClient'),
(2, 'yahya', 'chibani81', '2020-06-10', 'AD533', '785245', 'Maroc', 'ismail864', '123456789', 'Senior'),
(12, 'elkafhali', 'said', '2020-06-04', 'AD287433', '785245245', 'Maroc', 'mehdi864', '12345', 'B'),
(13, 'lily', 'dc', '2020-06-17', 'efd541df', 'dfdf5', 'fdf', 'lily', '123', 'Junior'),
(14, 'dd', 'dsds', '2020-06-23', 'sdsd', 'sdsd', 'sdsd', 'ismail8648', '123456789', 'Junior'),
(15, 'ds', 'sdd', '2020-06-24', 'sdds', 'dssd', 'ssd', 'ds', 'ds', 'Junior'),
(16, 'sdsf', 'sddds', '2020-06-16', 'dsdsd', 'sdsds', 'sdsdd', 'sddsd', 'sddsds', 'Junior'),
(17, 'ffg', 'fgfgfgfgf', '2020-06-28', 'fgfgfgf', 'fggfgfg', 'fgfgfgfggfg', 'dsdf', '123456789sd', 'Junior'),
(18, 'LARHCHIM', 'ZAKARIA', '1986-05-25', 'AD368740', '045HGO56', 'Maroc', 'zlarhchim@gmail.com', 'LARHCHIM', 'Senior'),
(19, 'LARHCHIM', 'HICHAM', '1981-04-23', 'AD2569', 'AG54842', 'Maroc', 'hicham@gmail.com', 'hicham', 'Junior'),
(20, 'Laalja', 'Nourredine', '1999-10-15', 'AD23568L', '123654789C', 'Espagnole', 'Nour@gmail.com', 'Nour123', 'Vieux'),
(21, 'El kafhali', 'Mouad', '1980-09-15', 'AD55FVSD', 'SDSD120563', 'Marocaine', 'Mouad@gmail.com', 'mouad123', 'Junior');

-- --------------------------------------------------------

--
-- Structure de la table `treservation`
--

CREATE TABLE `treservation` (
  `ID_Reservation` int(11) NOT NULL,
  `ID_Client` int(11) DEFAULT NULL,
  `ID_Vol` int(11) NOT NULL,
  `VilleDepart` varchar(30) DEFAULT NULL,
  `VilleArrivee` varchar(30) DEFAULT NULL,
  `DateDepart` date NOT NULL,
  `heureDepart` time NOT NULL,
  `classe` varchar(30) NOT NULL,
  `DateReservation` date NOT NULL,
  `NomPersonne` varchar(30) NOT NULL,
  `PrenomPersonne` varchar(30) NOT NULL,
  `DateArrivee` date NOT NULL,
  `Categorie` varchar(30) NOT NULL,
  `NumeroPasseport` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `treservation`
--

INSERT INTO `treservation` (`ID_Reservation`, `ID_Client`, `ID_Vol`, `VilleDepart`, `VilleArrivee`, `DateDepart`, `heureDepart`, `classe`, `DateReservation`, `NomPersonne`, `PrenomPersonne`, `DateArrivee`, `Categorie`, `NumeroPasseport`) VALUES
(29, 19, 21, 'y', 'y', '2020-07-24', '01:00:00', 'Affaire', '2020-07-21', 'LARHCHIM', 'ismail', '2020-07-25', 'Junior', 'AG54842'),
(32, 20, 21, 'Rabat', 'Russia', '2021-07-24', '01:00:00', 'Economie', '2020-08-31', 'Laalja', 'Nourredine', '2020-07-25', 'Junior', '123654789C'),
(33, 20, 21, 'Rabat', 'Russia', '2021-07-24', '01:00:00', 'Economie', '2020-08-31', 'ISMAIL', 'Nourredine', '2020-07-25', 'Junior', '123654789C'),
(37, 20, 30, 'Rabat', 'Russia', '2020-09-03', '04:00:00', '1ere', '2020-09-02', 'Laalja', 'Nourredine', '2020-09-03', 'Junior', '123654789C'),
(39, 21, 30, 'Rabat', 'Russia', '2018-09-03', '04:00:00', '1ere', '2020-09-04', 'El kafhali', 'Samir', '2020-09-03', 'Junior', 'SDSD120563');

-- --------------------------------------------------------

--
-- Structure de la table `ttrajet`
--

CREATE TABLE `ttrajet` (
  `ID_Trajet` int(11) NOT NULL,
  `VilleDepart` varchar(30) DEFAULT NULL,
  `LatitudeVilleDepart` double DEFAULT NULL,
  `LongitudeVilleDepart` double DEFAULT NULL,
  `VilleArrivee` varchar(30) DEFAULT NULL,
  `LatitudeVilleArrivee` double DEFAULT NULL,
  `LongitudeVilleArrivee` double DEFAULT NULL,
  `Distance` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `ttrajet`
--

INSERT INTO `ttrajet` (`ID_Trajet`, `VilleDepart`, `LatitudeVilleDepart`, `LongitudeVilleDepart`, `VilleArrivee`, `LatitudeVilleArrivee`, `LongitudeVilleArrivee`, `Distance`) VALUES
(14, 'Rabat', 33.956775199999996, -6.893655, 'Russia', 64.6863136, 97.7453061, 7285.876892886214),
(18, 'Rabat', 33.956775199999996, -6.893655, 'China', 35.000074, 104.999927, 9589.261203664533),
(19, 'Rabat', 33.956775199999996, -6.893655, 'Japon', 36.5748441, 139.2394179, 11433.270723269667),
(20, 'casa', 45424, 3213, 'fes', 123, 3123, 4572.210796727543);

-- --------------------------------------------------------

--
-- Structure de la table `tvol`
--

CREATE TABLE `tvol` (
  `ID_Vol` int(11) NOT NULL,
  `ID_Trajet` int(11) NOT NULL,
  `ID_Avion` int(11) NOT NULL,
  `DateDepart` date NOT NULL,
  `DateArrivee` date NOT NULL,
  `heureDepart` time NOT NULL,
  `heureArrivee` time NOT NULL,
  `Duree` varchar(30) NOT NULL,
  `NbrePlacesEco` int(11) NOT NULL,
  `NbrePlacesAff` int(11) NOT NULL,
  `NbrePlaces1ere` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `tvol`
--

INSERT INTO `tvol` (`ID_Vol`, `ID_Trajet`, `ID_Avion`, `DateDepart`, `DateArrivee`, `heureDepart`, `heureArrivee`, `Duree`, `NbrePlacesEco`, `NbrePlacesAff`, `NbrePlaces1ere`) VALUES
(21, 14, 15, '2020-07-24', '2020-07-25', '01:00:00', '02:00:00', '01:00:00', 48, 24, 100),
(30, 14, 14, '2020-09-03', '2020-09-03', '04:00:00', '05:00:00', '01:00:00', 120, 120, 7),
(31, 14, 14, '2020-09-03', '2020-09-03', '03:00:00', '04:00:00', '01:00:00', 120, 120, 10),
(32, 14, 14, '2020-09-03', '2020-09-03', '12:00:00', '13:00:00', '01:00:00', 120, 120, 10);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `tadmin`
--
ALTER TABLE `tadmin`
  ADD PRIMARY KEY (`ID_Admin`);

--
-- Index pour la table `tavion`
--
ALTER TABLE `tavion`
  ADD PRIMARY KEY (`ID_Avion`);

--
-- Index pour la table `tbillet`
--
ALTER TABLE `tbillet`
  ADD PRIMARY KEY (`ID_Billet`),
  ADD KEY `ID_Client` (`ID_Client`),
  ADD KEY `tbillet_ibfk_1` (`ID_Reservation`);

--
-- Index pour la table `tcategorie`
--
ALTER TABLE `tcategorie`
  ADD PRIMARY KEY (`ID_Categorie`);

--
-- Index pour la table `tclasse`
--
ALTER TABLE `tclasse`
  ADD PRIMARY KEY (`ID_Classe`);

--
-- Index pour la table `tclient`
--
ALTER TABLE `tclient`
  ADD PRIMARY KEY (`ID_Client`);

--
-- Index pour la table `treservation`
--
ALTER TABLE `treservation`
  ADD PRIMARY KEY (`ID_Reservation`),
  ADD KEY `c` (`ID_Client`),
  ADD KEY `v` (`ID_Vol`);

--
-- Index pour la table `ttrajet`
--
ALTER TABLE `ttrajet`
  ADD PRIMARY KEY (`ID_Trajet`);

--
-- Index pour la table `tvol`
--
ALTER TABLE `tvol`
  ADD PRIMARY KEY (`ID_Vol`),
  ADD KEY `av` (`ID_Avion`),
  ADD KEY `tr` (`ID_Trajet`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `tadmin`
--
ALTER TABLE `tadmin`
  MODIFY `ID_Admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `tavion`
--
ALTER TABLE `tavion`
  MODIFY `ID_Avion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT pour la table `tbillet`
--
ALTER TABLE `tbillet`
  MODIFY `ID_Billet` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- AUTO_INCREMENT pour la table `tcategorie`
--
ALTER TABLE `tcategorie`
  MODIFY `ID_Categorie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `tclasse`
--
ALTER TABLE `tclasse`
  MODIFY `ID_Classe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `tclient`
--
ALTER TABLE `tclient`
  MODIFY `ID_Client` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT pour la table `treservation`
--
ALTER TABLE `treservation`
  MODIFY `ID_Reservation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT pour la table `ttrajet`
--
ALTER TABLE `ttrajet`
  MODIFY `ID_Trajet` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT pour la table `tvol`
--
ALTER TABLE `tvol`
  MODIFY `ID_Vol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `tbillet`
--
ALTER TABLE `tbillet`
  ADD CONSTRAINT `tbillet_ibfk_1` FOREIGN KEY (`ID_Reservation`) REFERENCES `treservation` (`ID_Reservation`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `treservation`
--
ALTER TABLE `treservation`
  ADD CONSTRAINT `c` FOREIGN KEY (`ID_Client`) REFERENCES `tclient` (`ID_Client`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `v` FOREIGN KEY (`ID_Vol`) REFERENCES `tvol` (`ID_Vol`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `tvol`
--
ALTER TABLE `tvol`
  ADD CONSTRAINT `av` FOREIGN KEY (`ID_Avion`) REFERENCES `tavion` (`ID_Avion`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tr` FOREIGN KEY (`ID_Trajet`) REFERENCES `ttrajet` (`ID_Trajet`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
