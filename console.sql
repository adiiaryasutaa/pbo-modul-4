SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS nilai;
DROP TABLE IF EXISTS murid;
DROP TABLE IF EXISTS mapel;
DROP TABLE IF EXISTS kelas;
DROP TABLE IF EXISTS jurusan;

CREATE TABLE user
(
    username VARCHAR(10)               NOT NULL,
    password TEXT                      NOT NULL,
    level    ENUM ('siswa', 'petugas') NOT NULL
) ENGINE = 'InnoDB';

CREATE TABLE murid
(
    nis    VARCHAR(12) PRIMARY KEY NOT NULL,
    nama   VARCHAR(50)             NOT NULL,
    phone  VARCHAR(15)             NOT NULL,
    alamat VARCHAR(75)             NOT NULL
) ENGINE = 'InnoDB';

CREATE TABLE mapel
(
    id_mapel   VARCHAR(7) PRIMARY KEY NOT NULL,
    nama_mapel VARCHAR(50)            NOT NULL
) ENGINE = 'InnoDB';

CREATE TABLE kelas
(
    kode_kelas VARCHAR(7) PRIMARY KEY NOT NULL,
    nama_kelas VARCHAR(10)            NOT NULL
) ENGINE = 'InnoDB';

CREATE TABLE jurusan
(
    kode_jurusan VARCHAR(10) PRIMARY KEY NOT NULL,
    nama_jurusan VARCHAR(50)             NOT NULL
) ENGINE = 'InnoDB';

CREATE TABLE nilai
(
    id_mapel     VARCHAR(7)  NOT NULL,
    nis          VARCHAR(12) NOT NULL,
    kode_jurusan VARCHAR(10) NOT NULL,
    kode_kelas   VARCHAR(7)  NOT NULL,
    nilai_siswa  DOUBLE      NOT NULL,
    CONSTRAINT FK_IdMapel FOREIGN KEY (id_mapel) REFERENCES mapel (id_mapel) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_NisMurid FOREIGN KEY (nis) REFERENCES murid (nis) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_KodeJurusan FOREIGN KEY (kode_jurusan) REFERENCES jurusan (kode_jurusan) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_KodeKelas FOREIGN KEY (kode_kelas) REFERENCES kelas (kode_kelas) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = 'InnoDB';

DROP PROCEDURE IF EXISTS insertIntoTableUser;
DROP PROCEDURE IF EXISTS insertIntoTableMurid;
DROP PROCEDURE IF EXISTS insertIntoTableMapel;
DROP PROCEDURE IF EXISTS insertIntoTableKelas;
DROP PROCEDURE IF EXISTS insertIntoTableJurusan;
DROP PROCEDURE IF EXISTS insertIntoTableNilai;

DELIMITER ||
CREATE PROCEDURE insertIntoTableUser(in_username VARCHAR(10), in_password TEXT, in_level ENUM ('siswa', 'petugas'))
BEGIN
    INSERT INTO user(username, password, level) VALUES (in_username, in_password, in_level);
END ||;

DELIMITER ||
CREATE PROCEDURE insertIntoTableMurid(in_nis VARCHAR(12), in_nama VARCHAR(50), in_phone VARCHAR(15),
                                      in_alamat VARCHAR(75))
BEGIN
    INSERT INTO murid(nis, nama, phone, alamat) VALUES (in_nis, in_nama, in_phone, in_alamat);
END ||;

DELIMITER ||
CREATE PROCEDURE insertIntoTableMapel(in_id_mapel VARCHAR(7), in_nama_mapel VARCHAR(40))
BEGIN
    INSERT INTO mapel(id_mapel, nama_mapel) VALUES (in_id_mapel, in_nama_mapel);
END ||;

DELIMITER ||
CREATE PROCEDURE insertIntoTableKelas(in_kode_kelas VARCHAR(7), in_nama_kelas VARCHAR(10))
BEGIN
    INSERT INTO kelas(kode_kelas, nama_kelas) VALUES (in_kode_kelas, in_nama_kelas);
END ||;

DELIMITER ||
CREATE PROCEDURE insertIntoTableJurusan(in_kode_jurusan VARCHAR(10), in_nama_jurusan VARCHAR(30))
BEGIN
    INSERT INTO jurusan(kode_jurusan, nama_jurusan) VALUES (in_kode_jurusan, in_nama_jurusan);
END ||;

DELIMITER ||
CREATE PROCEDURE insertIntoTableNilai(in_id_mapel VARCHAR(7), in_nis VARCHAR(12), in_kode_jurusan VARCHAR(10),
                                      in_kode_kelas VARCHAR(7), in_nilai_siswa DOUBLE)
BEGIN
    INSERT INTO nilai(id_mapel, nis, kode_jurusan, kode_kelas, nilai_siswa)
    VALUES (in_id_mapel, in_nis,
            in_kode_jurusan, in_kode_kelas,
            in_nilai_siswa);
END ||;

CALL insertIntoTableUser('admin', 'admin', 'petugas');

CALL insertIntoTableMurid('28838', 'Pera Pradnyani', '087876837969', 'Jalan Nuansa Hijau Utama XXV No. 2');
CALL insertIntoTableMurid('28839', 'Adi Aryasuta', '087876837970', 'Jalan Nuansa Hijau Utama XXVI No. 3');
CALL insertIntoTableMurid('28840', 'Dwiki Nusanjaya', '087876837971', 'Jalan Nuansa Hijau Utama XXVII No. 4');
CALL insertIntoTableMurid('28841', 'Pande Suparsa', '087876837972', 'Jalan Nuansa Hijau Utama XXVIII No. 5');
CALL insertIntoTableMurid('28842', 'Wahyu Pranata', '087876837973', 'Jalan Nuansa Hijau Utama XXIX No. 6');

CALL insertIntoTableMapel('PBO', 'Pemrograman Berorientasi Obyek');
CALL insertIntoTableMapel('PWPB', 'Pemrograman Web dan Perangkat Bergerak');
CALL insertIntoTableMapel('DB', 'Basis Data');
CALL insertIntoTableMapel('PKK', 'Produk Kreatif dan Kewirausahaan');

CALL insertIntoTableKelas('K43', 'XII RPL 1');

CALL insertIntoTableJurusan('RPL', 'Rekayasa Perangkat Lunak');

CALL insertIntoTableNilai('PBO', '28838', 'RPL', 'k43', 90);
CALL insertIntoTableNilai('PWPB', '28838', 'RPL', 'k43', 87);
CALL insertIntoTableNilai('DB', '28838', 'RPL', 'k43', 87);
CALL insertIntoTableNilai('PKK', '28838', 'RPL', 'k43', 85);
CALL insertIntoTableNilai('PBO', '28839', 'RPL', 'k43', 95);
CALL insertIntoTableNilai('PWPB', '28839', 'RPL', 'k43', 95);
CALL insertIntoTableNilai('DB', '28839', 'RPL', 'k43', 95);
CALL insertIntoTableNilai('PKK', '28839', 'RPL', 'k43', 95);
CALL insertIntoTableNilai('PBO', '28840', 'RPL', 'k43', 95);
CALL insertIntoTableNilai('PWPB', '28840', 'RPL', 'k43', 95);
CALL insertIntoTableNilai('DB', '28840', 'RPL', 'k43', 95);
CALL insertIntoTableNilai('PKK', '28840', 'RPL', 'k43', 95);
CALL insertIntoTableNilai('PBO', '28841', 'RPL', 'k43', 90);
CALL insertIntoTableNilai('PWPB', '28841', 'RPL', 'k43', 90);
CALL insertIntoTableNilai('DB', '28841', 'RPL', 'k43', 90);
CALL insertIntoTableNilai('PKK', '28841', 'RPL', 'k43', 90);
CALL insertIntoTableNilai('PBO', '28842', 'RPL', 'k43', 95);
CALL insertIntoTableNilai('PWPB', '28842', 'RPL', 'k43', 95);
CALL insertIntoTableNilai('DB', '28842', 'RPL', 'k43', 95);
CALL insertIntoTableNilai('PKK', '28842', 'RPL', 'k43', 95);