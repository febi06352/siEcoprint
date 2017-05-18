-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 18, 2017 at 06:34 AM
-- Server version: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_siecoprint`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_agen`
--

CREATE TABLE IF NOT EXISTS `tb_agen` (
  `id_agen` int(11) NOT NULL,
  `nama_agen` varchar(40) DEFAULT NULL,
  `alamat_agen` varchar(100) DEFAULT NULL,
  `no_tlp` varchar(13) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_agen`
--

INSERT INTO `tb_agen` (`id_agen`, `nama_agen`, `alamat_agen`, `no_tlp`) VALUES
(1, 'agen fikri', 'Kapasan gang 5 no 4 rw 7 kapasan', '08671273812');

-- --------------------------------------------------------

--
-- Table structure for table `tb_alamat`
--

CREATE TABLE IF NOT EXISTS `tb_alamat` (
  `id_alamat` int(255) NOT NULL,
  `kota` varchar(20) DEFAULT NULL,
  `kecamatan` varchar(20) DEFAULT NULL,
  `jalan` varchar(100) DEFAULT NULL,
  `rt` varchar(10) DEFAULT NULL,
  `rw` varchar(10) DEFAULT NULL,
  `kode_pos` varchar(10) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_alamat`
--

INSERT INTO `tb_alamat` (`id_alamat`, `kota`, `kecamatan`, `jalan`, `rt`, `rw`, `kode_pos`) VALUES
(2, 'gresik', 'benjeng', 'munggugianti no 45', '35', '7', '61172'),
(3, 'Surabaya', 'gubeng', 'arif rahman hakim', '24', '26', '62176'),
(4, 'lamongan', 'brondong', 'lamongan', '23', '9', '781291'),
(5, 'jogjakarta', 'jogja', 'marioboro', '23', '8', '781200'),
(6, '', '', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `tb_login`
--

CREATE TABLE IF NOT EXISTS `tb_login` (
  `id_login` int(11) NOT NULL,
  `id_pegawai` int(11) DEFAULT NULL,
  `username` varchar(40) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `confirm_password` varchar(20) DEFAULT NULL,
  `hak_akses` varchar(10) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_login`
--

INSERT INTO `tb_login` (`id_login`, `id_pegawai`, `username`, `password`, `confirm_password`, `hak_akses`) VALUES
(1, 2, 'febi', 'qwerty', 'qwerty', '1'),
(2, 3, 'tulus', 'qwerty', 'qwerty', '2'),
(3, 4, 'ardi', 'qwerty', 'qwerty', '3');

-- --------------------------------------------------------

--
-- Table structure for table `tb_pegawai`
--

CREATE TABLE IF NOT EXISTS `tb_pegawai` (
  `id_pegawai` int(11) NOT NULL,
  `id_alamat` int(11) DEFAULT NULL,
  `nama` varchar(40) DEFAULT NULL,
  `no_tlp` varchar(13) DEFAULT NULL,
  `tanggal_gabung` varchar(20) DEFAULT NULL,
  `tanggal_lahir` varchar(20) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pegawai`
--

INSERT INTO `tb_pegawai` (`id_pegawai`, `id_alamat`, `nama`, `no_tlp`, `tanggal_gabung`, `tanggal_lahir`) VALUES
(2, 2, 'febi', '085607774866', '24 Apr 17', '22 Agu 96'),
(3, 3, 'tulus', '08716271288', '12 Mei 17', '15 Mei 96'),
(4, 4, 'ardi', '081627182991', '17 Mei 17', '19 Mei 97');

-- --------------------------------------------------------

--
-- Table structure for table `tb_pelanggan`
--

CREATE TABLE IF NOT EXISTS `tb_pelanggan` (
  `id_pelanggan` int(11) NOT NULL,
  `nama` varchar(40) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `no_tlpn` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pelanggan`
--

INSERT INTO `tb_pelanggan` (`id_pelanggan`, `nama`, `alamat`, `no_tlpn`) VALUES
(1, 'tulus', 'desa grogol jakarta no 18 rt 32 rw 7', '081723812909');

-- --------------------------------------------------------

--
-- Table structure for table `tb_pembelian`
--

CREATE TABLE IF NOT EXISTS `tb_pembelian` (
  `id_pembelian` varchar(40) NOT NULL,
  `id_stok` varchar(40) DEFAULT NULL,
  `id_pegawai` int(11) DEFAULT NULL,
  `id_agen` int(11) DEFAULT NULL,
  `nama_barang` varchar(40) DEFAULT NULL,
  `tipe_barang` varchar(30) DEFAULT NULL,
  `banyak_barang` varchar(10) DEFAULT NULL,
  `harga_barang` varchar(10) DEFAULT NULL,
  `total_harga` varchar(10) DEFAULT NULL,
  `tanggal` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pembelian`
--

INSERT INTO `tb_pembelian` (`id_pembelian`, `id_stok`, `id_pegawai`, `id_agen`, `nama_barang`, `tipe_barang`, `banyak_barang`, `harga_barang`, `total_harga`, `tanggal`) VALUES
('252020170420452000', 'TI25132017031331', 2, 1, 'tes', NULL, '2', '1000', '2000', NULL),
('28022017112283600000', 'PR25582017065821', 2, 1, 'printer', NULL, '3', '1200000', '3600000', NULL),
('30082017038102280000', 'PR25582017065821', 2, 1, 'printer', NULL, '120', '19000', '2280000', '2017-04-30'),
('PB08282017032825', 'PR25582017065821', 2, 1, 'tes', 'printer', '19', '100000', '1900000', '2017-05-08');

--
-- Triggers `tb_pembelian`
--
DELIMITER $$
CREATE TRIGGER `tg_tambahStok` AFTER INSERT ON `tb_pembelian`
 FOR EACH ROW BEGIN
     UPDATE tb_stokbarang SET banyak = banyak + NEW.banyak_barang
     WHERE id_Stok = NEW.id_stok;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_pengadaanbarang`
--

CREATE TABLE IF NOT EXISTS `tb_pengadaanbarang` (
  `id_pengadaanBarang` varchar(255) NOT NULL,
  `no_pengadaan` varchar(20) DEFAULT NULL,
  `id_pegawai` int(11) DEFAULT NULL,
  `nama/kategori_barang` varchar(40) DEFAULT NULL,
  `tipe_barang` varchar(40) DEFAULT NULL,
  `tanggal_permintaanBarang` date DEFAULT NULL,
  `jumlah_barang` varchar(10) DEFAULT NULL,
  `harga_satuan` varchar(20) DEFAULT NULL,
  `total_anggaran` varchar(10) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pengadaanbarang`
--

INSERT INTO `tb_pengadaanbarang` (`id_pengadaanBarang`, `no_pengadaan`, `id_pegawai`, `nama/kategori_barang`, `tipe_barang`, `tanggal_permintaanBarang`, `jumlah_barang`, `harga_satuan`, `total_anggaran`, `status`) VALUES
('102953Meipr2', 'PB11292017102949', 2, 'printer', 'dtg', '2017-05-05', '21', '4000', '84000', 'Waiting'),
('102959Meipr2', 'PB11292017102949', 2, 'printer', 'UV', '2017-05-11', '21', '4000', '84000', 'Waiting');

-- --------------------------------------------------------

--
-- Table structure for table `tb_penjualan`
--

CREATE TABLE IF NOT EXISTS `tb_penjualan` (
  `id_penjualan` varchar(20) NOT NULL,
  `no_nota` varchar(20) DEFAULT NULL,
  `id_pelanggan` int(11) DEFAULT NULL,
  `id_stok` varchar(40) DEFAULT NULL,
  `id_pegawai` int(11) DEFAULT NULL,
  `nama_barang` varchar(40) DEFAULT NULL,
  `tipe_barang` varchar(20) DEFAULT NULL,
  `banyak_barang` varchar(10) DEFAULT NULL,
  `diskon` int(3) DEFAULT NULL,
  `harga_barang` varchar(10) DEFAULT NULL,
  `total_harga` varchar(10) DEFAULT NULL,
  `tanggal` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_penjualan`
--

INSERT INTO `tb_penjualan` (`id_penjualan`, `no_nota`, `id_pelanggan`, `id_stok`, `id_pegawai`, `nama_barang`, `tipe_barang`, `banyak_barang`, `diskon`, `harga_barang`, `total_harga`, `tanggal`) VALUES
('1', 'N11512017085132', 1, 'TI25132017031331', 2, 'tinta', 'msdas', '10', 0, '20000', '20000', '2017-04-12'),
('2', 'N11512017085132', 1, 'PR25582017065821', 2, 'printer', 'cmyk', '22', 0, '24500', '539000', '2017-05-01'),
('3', 'N11512017085132', 1, 'PR25582017065821', 2, 'printer', 'l120', '19', 5, '1200000', '21660000', '2017-05-02'),
('PJ08102017021049', 'N11512017081131', 1, 'PR25582017065821', 2, 'tes', '1293', '32', 15, '9000', '244800', '2017-05-08'),
('PJ08102017021059', 'N11512017081131', 1, 'PR25582017065821', 2, 'tes', '1293', '32', 15, '2000', '54400', '2017-05-08'),
('PJ1107201709729', 'N1108201709835', 1, 'PRcofee1106201709606', 2, 'printer', 'cofee', '2', 20, '12000', '19200', '2017-05-11'),
('PJ1108201709817', 'N1108201709835', 1, 'PRdtg1104201709424', 2, 'printer', 'dtg', '1', 20, '12000', '9600', '2017-05-11'),
('PJ1108201709838', 'N1108201709835', 1, 'PRuv1105201709514', 2, 'printer', 'uv', '2', 20, '12000', '19200', '2017-05-11'),
('PJ11522017085208', 'N11512017085141', 1, 'PR25582017065821', 2, 'printer', 'l120', '12', 32, '444', '3624', '2017-05-16'),
('PJ11522017085227', 'N11512017085141', 1, 'TI25132017031331', 2, 'tinta', 'cmyk', '12', 32, '444', '3624', '2017-05-16');

--
-- Triggers `tb_penjualan`
--
DELIMITER $$
CREATE TRIGGER `tg_kurangStok` AFTER INSERT ON `tb_penjualan`
 FOR EACH ROW BEGIN
     UPDATE tb_stokbarang SET banyak = banyak - NEW.banyak_barang
     WHERE id_Stok = NEW.id_stok;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_returbarang`
--

CREATE TABLE IF NOT EXISTS `tb_returbarang` (
  `id_retur` int(11) NOT NULL,
  `id_stok` varchar(40) DEFAULT NULL,
  `id_penjualan` varchar(20) DEFAULT NULL,
  `tanggal_retur` date DEFAULT NULL,
  `jumlah_barang` varchar(10) DEFAULT NULL,
  `alasan_retur` varchar(100) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_returbarang`
--

INSERT INTO `tb_returbarang` (`id_retur`, `id_stok`, `id_penjualan`, `tanggal_retur`, `jumlah_barang`, `alasan_retur`, `status`) VALUES
(1, NULL, NULL, '2017-01-01', '10', NULL, NULL),
(2, NULL, NULL, '2017-01-02', '20', NULL, NULL),
(3, NULL, NULL, '2017-01-03', '30', NULL, NULL),
(4, NULL, NULL, '2017-02-01', '2', NULL, NULL),
(5, NULL, NULL, '2017-02-02', '4', NULL, NULL),
(6, NULL, NULL, '2017-02-03', '1', NULL, NULL),
(7, NULL, NULL, '2017-03-01', '2', NULL, NULL),
(8, NULL, NULL, '2017-01-04', '3', NULL, NULL),
(9, NULL, NULL, '2017-01-05', '4', NULL, NULL),
(10, NULL, NULL, '2017-01-06', '10', NULL, NULL),
(11, NULL, NULL, '2017-03-02', '32', NULL, NULL),
(12, 'PR25582017065821', '1', '2017-05-18', '10', 'pecah', 'proses');

-- --------------------------------------------------------

--
-- Table structure for table `tb_stokbarang`
--

CREATE TABLE IF NOT EXISTS `tb_stokbarang` (
  `id_stok` varchar(40) NOT NULL,
  `kategori_barang` varchar(40) DEFAULT NULL,
  `tipe_barang` varchar(10) DEFAULT NULL,
  `banyak` varchar(10) DEFAULT NULL,
  `harga_beli` varchar(10) DEFAULT NULL,
  `harga_jual` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_stokbarang`
--

INSERT INTO `tb_stokbarang` (`id_stok`, `kategori_barang`, `tipe_barang`, `banyak`, `harga_beli`, `harga_jual`) VALUES
('PR25582017065821', 'Printer', 'l120', '27', NULL, '3500'),
('PRcofee1106201709606', 'printer', 'cofee', '188', '9000', '12000'),
('PRdtg1104201709424', 'printer', 'dtg', '99', '20000', '35000'),
('PRuv1105201709514', 'printer', 'uv', '43', '2500', '5000'),
('TI25132017031331', 'tinta ink bride', 'cmyk', '98', NULL, '14000');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_agen`
--
ALTER TABLE `tb_agen`
  ADD PRIMARY KEY (`id_agen`);

--
-- Indexes for table `tb_alamat`
--
ALTER TABLE `tb_alamat`
  ADD PRIMARY KEY (`id_alamat`);

--
-- Indexes for table `tb_login`
--
ALTER TABLE `tb_login`
  ADD PRIMARY KEY (`id_login`), ADD KEY `fk_pegawai3` (`id_pegawai`);

--
-- Indexes for table `tb_pegawai`
--
ALTER TABLE `tb_pegawai`
  ADD PRIMARY KEY (`id_pegawai`), ADD KEY `fk_idAlamat` (`id_alamat`);

--
-- Indexes for table `tb_pelanggan`
--
ALTER TABLE `tb_pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`);

--
-- Indexes for table `tb_pembelian`
--
ALTER TABLE `tb_pembelian`
  ADD PRIMARY KEY (`id_pembelian`), ADD KEY `fk_stok2` (`id_stok`), ADD KEY `fk_agen` (`id_agen`), ADD KEY `fk_pegawai1` (`id_pegawai`);

--
-- Indexes for table `tb_pengadaanbarang`
--
ALTER TABLE `tb_pengadaanbarang`
  ADD PRIMARY KEY (`id_pengadaanBarang`), ADD KEY `fk_pegawai2` (`id_pegawai`);

--
-- Indexes for table `tb_penjualan`
--
ALTER TABLE `tb_penjualan`
  ADD PRIMARY KEY (`id_penjualan`), ADD KEY `fk_stok` (`id_stok`), ADD KEY `fk_pelanggan` (`id_pelanggan`), ADD KEY `fk_pegawai` (`id_pegawai`);

--
-- Indexes for table `tb_returbarang`
--
ALTER TABLE `tb_returbarang`
  ADD PRIMARY KEY (`id_retur`), ADD KEY `fk_stok1` (`id_stok`), ADD KEY `fk_penjualan` (`id_penjualan`);

--
-- Indexes for table `tb_stokbarang`
--
ALTER TABLE `tb_stokbarang`
  ADD PRIMARY KEY (`id_stok`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_agen`
--
ALTER TABLE `tb_agen`
  MODIFY `id_agen` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tb_alamat`
--
ALTER TABLE `tb_alamat`
  MODIFY `id_alamat` int(255) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `tb_login`
--
ALTER TABLE `tb_login`
  MODIFY `id_login` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tb_pegawai`
--
ALTER TABLE `tb_pegawai`
  MODIFY `id_pegawai` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tb_pelanggan`
--
ALTER TABLE `tb_pelanggan`
  MODIFY `id_pelanggan` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tb_returbarang`
--
ALTER TABLE `tb_returbarang`
  MODIFY `id_retur` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_login`
--
ALTER TABLE `tb_login`
ADD CONSTRAINT `fk_pegawai3` FOREIGN KEY (`id_pegawai`) REFERENCES `tb_pegawai` (`id_pegawai`);

--
-- Constraints for table `tb_pegawai`
--
ALTER TABLE `tb_pegawai`
ADD CONSTRAINT `fk_idAlamat` FOREIGN KEY (`id_alamat`) REFERENCES `tb_alamat` (`id_alamat`);

--
-- Constraints for table `tb_pembelian`
--
ALTER TABLE `tb_pembelian`
ADD CONSTRAINT `fk_agen` FOREIGN KEY (`id_agen`) REFERENCES `tb_agen` (`id_agen`),
ADD CONSTRAINT `fk_pegawai1` FOREIGN KEY (`id_pegawai`) REFERENCES `tb_pegawai` (`id_pegawai`),
ADD CONSTRAINT `fk_stok2` FOREIGN KEY (`id_stok`) REFERENCES `tb_stokbarang` (`id_stok`);

--
-- Constraints for table `tb_pengadaanbarang`
--
ALTER TABLE `tb_pengadaanbarang`
ADD CONSTRAINT `fk_pegawai2` FOREIGN KEY (`id_pegawai`) REFERENCES `tb_pegawai` (`id_pegawai`);

--
-- Constraints for table `tb_penjualan`
--
ALTER TABLE `tb_penjualan`
ADD CONSTRAINT `fk_pegawai` FOREIGN KEY (`id_pegawai`) REFERENCES `tb_pegawai` (`id_pegawai`),
ADD CONSTRAINT `fk_pelanggan` FOREIGN KEY (`id_pelanggan`) REFERENCES `tb_pelanggan` (`id_pelanggan`),
ADD CONSTRAINT `fk_stok` FOREIGN KEY (`id_stok`) REFERENCES `tb_stokbarang` (`id_stok`);

--
-- Constraints for table `tb_returbarang`
--
ALTER TABLE `tb_returbarang`
ADD CONSTRAINT `fk_penjualan` FOREIGN KEY (`id_penjualan`) REFERENCES `tb_penjualan` (`id_penjualan`),
ADD CONSTRAINT `fk_stok1` FOREIGN KEY (`id_stok`) REFERENCES `tb_stokbarang` (`id_stok`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
