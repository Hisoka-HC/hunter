DROP DATABASE IF EXISTS elabel_hospital_service;
CREATE DATABASE elabel_hospital_service;
USE elabel_hospital_service;

CREATE TABLE hospital (
  id      INT PRIMARY KEY AUTO_INCREMENT,
  name    VARCHAR(32),
  address VARCHAR(32),
  client_login_time TIMESTAMP
);

CREATE TABLE department (
  id          INT PRIMARY KEY AUTO_INCREMENT,
  name        VARCHAR(32),
  hospital_id INT,
  FOREIGN KEY (hospital_id) REFERENCES hospital (id)
);

CREATE TABLE `floor` (
  id          INT PRIMARY KEY AUTO_INCREMENT,
  name        VARCHAR(32),
  hospital_id INT,
  FOREIGN KEY (hospital_id) REFERENCES hospital (id)
);

CREATE TABLE room (
  id          INT PRIMARY KEY AUTO_INCREMENT,
  name        VARCHAR(32),
  code        VARCHAR(32),
  floor_id    INT,
  hospital_id INT,
  department_id INT,
  FOREIGN KEY (hospital_id) REFERENCES hospital (id),
  FOREIGN KEY (floor_id) REFERENCES floor (id),
  FOREIGN KEY (department_id) REFERENCES department (id)
);

#医护人员职位
CREATE TABLE `position` (
  id                   INT PRIMARY KEY AUTO_INCREMENT,
  name                 VARCHAR(32),
  superior_position_id INT
);

CREATE VIEW v_position AS
  SELECT
    `position`.*,
    superior.name AS superior_position_name
  FROM `position`
    LEFT JOIN `position` AS superior ON superior.id = `position`.superior_position_id;

CREATE TABLE staff (
  id            INT PRIMARY KEY AUTO_INCREMENT,
  name          VARCHAR(32),
  position_id   INT,
  superior_id   INT,
  department_id INT,
  FOREIGN KEY (position_id) REFERENCES `position` (id)
);

DROP VIEW IF EXISTS v_staff;
CREATE VIEW v_staff AS
  SELECT
    staff.*,
    position.name   AS position_name,
    superior.name   AS superior,
    department.name AS department_name
  FROM staff
    LEFT JOIN `position` ON `position`.id = staff.position_id
    LEFT JOIN staff AS superior ON superior.id = staff.superior_id
    LEFT JOIN department ON department.id = staff.department_id;

#病患特征类别
CREATE TABLE feature_category (
  id                   INT PRIMARY KEY AUTO_INCREMENT,
  name                 VARCHAR(32),
  superior_category_id INT,
  hospital_id          INT,
  FOREIGN KEY (hospital_id) REFERENCES hospital (id)
);

DROP VIEW IF EXISTS v_feature_category;
CREATE VIEW v_feature_category AS
  SELECT
    feature_category.*,
    superior.name AS superior_category_feature_name
  FROM feature_category
    LEFT JOIN feature_category AS superior ON feature_category.superior_category_id = superior.id;

CREATE TABLE feature (
  id                  INT PRIMARY KEY AUTO_INCREMENT,
  name                VARCHAR(32),
  feature_category_id INT,
  hospital_id         INT,
  FOREIGN KEY (feature_category_id) REFERENCES feature_category (id)
);

CREATE VIEW v_feature AS
  SELECT
    feature.*,
    feature_category.name AS feature_category_name
  FROM feature
    LEFT JOIN feature_category ON feature.feature_category_id = feature_category.id;

CREATE TABLE disease_category (
  id                   INT PRIMARY KEY AUTO_INCREMENT,
  name                 VARCHAR(32),
  superior_category_id INT,
  hospital_id          INT,
  FOREIGN KEY (hospital_id) REFERENCES hospital (id)
);

CREATE VIEW v_disease_category AS
  SELECT
    disease_category.*,
    superior.name AS superior_disease_category_id
  FROM disease_category
    LEFT JOIN disease_category AS superior ON superior.id = disease_category.superior_category_id;

CREATE TABLE disease (
  id                  INT PRIMARY KEY AUTO_INCREMENT,
  name                VARCHAR(32),
  disease_category_id INT,
  hospital_id         INT,
  FOREIGN KEY (disease_category_id) REFERENCES feature_category (id)
);

CREATE VIEW v_disease AS
  SELECT
    disease.*,
    disease_category.name AS disease_category_name
  FROM disease
    LEFT JOIN disease_category ON disease.disease_category_id = disease_category.id;

CREATE TABLE patient (
  id            INT PRIMARY KEY AUTO_INCREMENT,
  hospital_id   INT,
  name          VARCHAR(32),
  age           INT, #price
  gender        ENUM ('male', 'female'),
  staff_id_1    INT,
  staff_id_2    INT,
  department_id INT,
  bed_id        INT,
  disease_id    INT,
  admitted_time DATETIME,
  status        ENUM ('normal', 'updated'),
  allergy_id    INT,
  nursingLevel_id  INT,
  eating_id     INT,
  FOREIGN KEY (allergy_id) REFERENCES allergy(id),
  FOREIGN KEY (nursingLevel_id) REFERENCES nursingLevel(id),
  FOREIGN KEY (eating_id) REFERENCES eating(id),
  FOREIGN KEY (staff_id_1) REFERENCES staff (id),
  FOREIGN KEY (staff_id_2) REFERENCES staff (id),
  FOREIGN KEY (disease_id) REFERENCES disease (id),
  FOREIGN KEY (department_id) REFERENCES department (id),
  FOREIGN KEY (hospital_id) REFERENCES hospital (id)
);
ALTER TABLE patient
  AUTO_INCREMENT = 10001;

#显示映射
CREATE TABLE header (
  id          INT     AUTO_INCREMENT PRIMARY KEY,
  hospital_id INT,
  field_name  VARCHAR(32)                                                                        NOT NULL,
  alias       VARCHAR(32)                                                                        NOT NULL,
  camel       VARCHAR(32)                                                                        NOT NULL,
  type        ENUM ('id', 'double', 'text', 'barcode', 'qrcode', 'datetime', 'boolean', 'image') NOT NULL,
  enabled     BOOLEAN DEFAULT FALSE,
  `order`     INT,
  FOREIGN KEY (hospital_id) REFERENCES hospital (id)
);


CREATE TABLE esl (
  tiny_ip             VARCHAR(20) PRIMARY KEY,
  hospital_id         INT NOT NULL,
  tag_type            VARCHAR(6),
  tag_ver             VARCHAR(6),
  stopped             BIT,
  bat_info            SMALLINT,
  bat_percent         INT,
  ap_rssi             SMALLINT,
  esl_rssi            SMALLINT,
  a_token             SMALLINT,
  batch               DATETIME,
  login_count         INT,
  update_count        INT,
  login_time          DATETIME,
  update_time         DATETIME,
  updated_time        DATETIME,
  channel             SMALLINT,
  channel_b           SMALLINT,
  sys_map_id          INT,
  esl_map_id          INT,
  price               INTEGER,
  new_price           INTEGER,
  pattern_id          VARCHAR(20),
  cmd                 INT,
  update_state        BOOLEAN,
  `cloud_update_time` DATETIME,
  FOREIGN KEY (hospital_id) REFERENCES hospital (id),
  INDEX (cloud_update_time),
  INDEX (update_state),


  patient_id          INT, #barcode
  FOREIGN KEY (patient_id) REFERENCES patient (id)
);

CREATE TABLE `elabel_hospital_service`.`allergy`( `id` INT NOT NULL AUTO_INCREMENT, `name` VARCHAR(10),  PRIMARY KEY (`id`) );

CREATE TABLE `elabel_hospital_service`.`nursingLevel`( `id` INT NOT NULL AUTO_INCREMENT, `name` VARCHAR(10),  PRIMARY KEY (`id`) );

CREATE TABLE `elabel_hospital_service`.`eating`( `id` INT NOT NULL AUTO_INCREMENT, `name` VARCHAR(10),  PRIMARY KEY (`id`) );


CREATE VIEW v_esl AS
  SELECT
    esl.*,
    patient.name AS patient_name,
    patient.id as patient_id,
    patient.department_id
  FROM esl
    LEFT JOIN patient ON esl.`bed_id` = patient.`bed_id`;

CREATE TABLE user (
  id          INT PRIMARY KEY AUTO_INCREMENT,
  email       VARCHAR(64) NOT NULL UNIQUE,
  password    VARCHAR(16) NOT NULL,
  hospital_id INT         NOT NULL,

  FOREIGN KEY (hospital_id) REFERENCES hospital (id),
  INDEX (email)
);


CREATE TABLE bed (
  id          INT PRIMARY KEY AUTO_INCREMENT,
  name        VARCHAR(32),
  room_id     INT,
  hospital_id INT,

  FOREIGN KEY (room_id) REFERENCES room (id),
  FOREIGN KEY (hospital_id) REFERENCES hospital (id)
);

ALTER TABLE patient
  ADD CONSTRAINT FOREIGN KEY (bed_id) REFERENCES bed (id);

drop view IF EXISTS v_bed;
CREATE VIEW v_bed AS
  SELECT
    bed.*,
    room.name  AS room_name,
    room.floor_id,
    floor.name AS floor_name,
    patient.id IS NULL AS available
  FROM bed
    LEFT JOIN room ON room.id = bed.room_id
    LEFT JOIN FLOOR ON room.floor_id = floor.id
    LEFT JOIN patient ON bed.id=patient.`bed_id`;

DROP VIEW IF EXISTS v_room;
CREATE VIEW v_room AS
  SELECT
    room.*,
    floor.name    AS floor_name,
    available.available_count,
    total.bed_count
  FROM room
    LEFT JOIN `floor` ON room.floor_id = `floor`.id
    LEFT JOIN
	    (SELECT room.id AS room_id, COUNT(v_bed.id) AS available_count FROM room
	    JOIN v_bed ON room.id = v_bed.room_id WHERE v_bed.id IS NULL OR v_bed.`available`=1 GROUP BY room.id) AS available
	    ON available.room_id=room.id
    LEFT JOIN
    (SELECT room.id AS room_id, COUNT(v_bed.id) AS bed_count FROM room
    JOIN v_bed ON room.id = v_bed.room_id GROUP BY room.id) AS total
    ON total.room_id=room.id;

DROP VIEW IF EXISTS v_floor;
CREATE VIEW v_floor AS
     SELECT
    floor.*,
    COUNT(v_room.id) AS room_count,
    SUM(v_room.`available_count`) AS available_count,
    SUM(v_room.`bed_count`) AS bed_count
  FROM FLOOR
    LEFT JOIN v_room ON floor.id = v_room.floor_id GROUP BY floor.`id`;

insert into hospital(name) value('test');
insert into user(email, password, hospital_id) value('test','123456',1);


DROP VIEW IF EXISTS v_patient;
CREATE VIEW v_patient AS
SELECT p.*,dp.`name` AS department_name,s.`name` AS staff1_name,bed.`name` AS bed_name,st.`name` AS staff2_name,a.`name` AS allergy_name,n.`name` AS nursingLevel_name,e.`name` AS eating_name
FROM patient AS p
LEFT JOIN department dp ON p.`department_id`=dp.`id`
LEFT JOIN bed ON p.`bed_id`=bed.`id`
LEFT JOIN staff AS s ON p.`staff_id_1`=s.`id`
LEFT JOIN staff AS st ON p.`staff_id_2`=st.`id`
LEFT JOIN allergy AS a ON p.`allergy_id`=a.`id`
LEFT JOIN nursingLevel AS n ON p.`nursingLevel_id`=n.`id`
LEFT JOIN eating AS e ON p.`eating_id`=e.`id`


