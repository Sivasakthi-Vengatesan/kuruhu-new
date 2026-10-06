-- PRAMAAN Seed Data Migration V2
-- Populates initial master records, demo users, FIRs, persons, evidence, and intelligence data

-- 1. Roles
INSERT INTO roles (id, name, description) VALUES
(1, 'ROLE_ADMIN', 'System Administrator with full access'),
(2, 'ROLE_INVESTIGATOR', 'Investigating Officer / Crime Analyst'),
(3, 'ROLE_POLICE_USER', 'General Police Station Officer'),
(4, 'ROLE_ANALYST', 'Intelligence & Forensic Analyst'),
(5, 'ROLE_CIVILIAN', 'Public Portal User')
ON CONFLICT (name) DO NOTHING;

-- 2. Police Stations
INSERT INTO police_stations (id, station_code, name, district, jurisdiction_area, contact_number, latitude, longitude) VALUES
(1, 'PS-JAYANAGAR', 'Jayanagar PS', 'Bengaluru City', 'Jayanagar 1st to 9th Blocks', '080-22942555', 12.9304, 77.5835),
(2, 'PS-INDIRANAGAR', 'Indiranagar PS', 'Bengaluru City', 'Indiranagar, Domlur, HAL 2nd Stage', '080-22942566', 12.9784, 77.6408),
(3, 'PS-HALASURUGATE', 'Halasuru Gate PS', 'Bengaluru City', 'KR Market, City Market, Corporation Circle', '080-22942577', 12.9657, 77.5762),
(4, 'PS-PEENYA', 'Peenya PS', 'Bengaluru City', 'Peenya Industrial Area Phase 1 to 4', '080-22942588', 13.0285, 77.5197),
(5, 'PS-UPPARPET', 'Upparpet PS', 'Bengaluru City', 'Majestic, Kempegowda Bus Station, Railway Station', '080-22942599', 12.9772, 77.5713),
(6, 'PS-ECITY', 'Electronic City PS', 'Bengaluru City', 'Electronic City Phase 1 & 2, Hosur Road Toll', '080-22942510', 12.8452, 77.6602),
(7, 'PS-MADIWALA', 'Madiwala PS', 'Bengaluru City', 'Madiwala Market, BTM Layout 2nd Stage, Silk Board', '080-22942520', 12.9226, 77.6174)
ON CONFLICT (station_code) DO NOTHING;

-- 3. Officers
INSERT INTO officers (id, badge_number, name, rank_title, police_station_id, phone, email) VALUES
(1, 'KSP-30412', 'Insp. Meera Kulkarni', 'Police Inspector', 1, '+91 9845012345', 'meera.kulkarni@ksp.gov.in'),
(2, 'KSP-30413', 'PSI Divya R', 'Police Sub-Inspector', 1, '+91 9845012346', 'divya.r@ksp.gov.in'),
(3, 'KSP-30414', 'Insp. Ramesh Gowda', 'Police Inspector', 3, '+91 9845012347', 'ramesh.gowda@ksp.gov.in'),
(4, 'KSP-30415', 'PSI Anand T', 'Police Sub-Inspector', 6, '+91 9845012348', 'anand.t@ksp.gov.in')
ON CONFLICT (badge_number) DO NOTHING;

-- 4. Users (Passwords hashed with BCrypt: 'password123' -> $2a$10$wT0lV3kP3aUvO8xZ1C3Dae7aFw2zP.u9h0Z.t7W0x1F7q2a8w7eGy / $2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG)
INSERT INTO users (id, username, email, password_hash, full_name, phone, badge_number, district, police_station_id, is_active) VALUES
(1, 'admin@ksp.gov.in', 'admin@ksp.gov.in', '$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG', 'Admin Officer', '+91 9876543210', 'ADM-001', 'Bengaluru City', 1, true),
(2, 'meera.kulkarni@ksp.gov.in', 'meera.kulkarni@ksp.gov.in', '$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG', 'Insp. Meera Kulkarni', '+91 9845012345', 'KSP-30412', 'Bengaluru City', 1, true),
(3, 'investigator@ksp.gov.in', 'investigator@ksp.gov.in', '$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG', 'Senior Investigator', '+91 9845099999', 'KSP-99001', 'Bengaluru City', 1, true),
(4, '9876543210', 'officer.mobile@ksp.gov.in', '$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG', 'Officer (9876543210)', '+91 9876543210', 'KSP-1092', 'Bengaluru City', 1, true)
ON CONFLICT (username) DO NOTHING;

INSERT INTO user_roles (user_id, role_id) VALUES
(1, 1),
(2, 2),
(2, 3),
(3, 2),
(4, 3)
ON CONFLICT DO NOTHING;

-- 5. FIRs
INSERT INTO firs (id, fir_number, title, summary, police_station_id, station_name, district, investigating_officer, priority, status, sections, incident_date, registered_at, updatedAt) VALUES
(101, '0245/2026', 'Chain snatching and assault — Jayanagar market', 'Complainant reports gold chain snatching by two persons on a black motorcycle near Jayanagar 4th Block Market. Minor injuries sustained. CCTV coverage available; two suspects identified through footage and CDR analysis.', 1, 'Jayanagar PS', 'Bengaluru City', 'Insp. Meera Kulkarni', 'high', 'investigating', '["BNS 304(2)", "BNS 115(2)", "BNS 351(3)"]'::jsonb, '2026-07-15 18:25:00+05:30', '2026-07-15 19:20:00+05:30', '2026-07-22 18:10:00+05:30'),
(102, '0232/2026', 'House burglary — Indiranagar residence', 'Night-time break-in through rear window; jewellery and cash stolen. Fingerprint lifts under FSL analysis. Motorcycle matching V-501 seen on street CCTV at 01:40.', 2, 'Indiranagar PS', 'Bengaluru City', 'PSI Divya R', 'medium', 'investigating', '["BNS 331(4)", "BNS 305"]'::jsonb, '2026-07-18 02:00:00+05:30', '2026-07-18 07:55:00+05:30', '2026-07-21 12:30:00+05:30'),
(103, '0219/2026', 'Vehicle theft ring — KR Market', 'White Swift stolen from KR Market parking; third similar theft in the area in six weeks. CCTV shows two known suspects. Pattern analysis suggests organised activity.', 3, 'Halasuru Gate PS', 'Bengaluru City', 'Insp. Ramesh Gowda', 'high', 'review', '["BNS 303(2)", "BNS 317(2)"]'::jsonb, '2026-07-12 02:15:00+05:30', '2026-07-12 09:10:00+05:30', '2026-07-20 16:40:00+05:30'),
(104, '0148/2026', 'Illegal money lending and extortion — Peenya', 'Extortion complaint against organised lending racket operating from a Peenya godown. UPI trail links collections across three FIRs. Ledger seized; financial analysis in progress.', 4, 'Peenya PS', 'Bengaluru City', 'Insp. Meera Kulkarni', 'critical', 'investigating', '["BNS 308(5)", "BNS 351(2)", "KMPL Act 9"]'::jsonb, '2026-06-28 13:00:00+05:30', '2026-06-28 13:00:00+05:30', '2026-07-22 20:50:00+05:30'),
(105, '0096/2026', 'Highway cargo pilferage — Hosur Road', 'Repeated pilferage from parked cargo trucks near the toll plaza. One accused identified; case closed after charge sheet.', 6, 'Electronic City PS', 'Bengaluru City', 'PSI Anand T', 'low', 'closed', '["BNS 303(2)"]'::jsonb, '2026-05-30 10:20:00+05:30', '2026-05-30 10:20:00+05:30', '2026-07-08 11:00:00+05:30'),
(106, '0251/2026', 'Mobile phone snatching — Majestic bus stand', 'Phone snatched at platform 12 during evening rush. Complaint registered; awaiting CCTV pull from BMTC control room.', 5, 'Upparpet PS', 'Bengaluru City', 'Insp. Ramesh Gowda', 'medium', 'registered', '["BNS 304(2)"]'::jsonb, '2026-07-22 19:35:00+05:30', '2026-07-22 19:35:00+05:30', '2026-07-22 19:35:00+05:30')
ON CONFLICT (id) DO NOTHING;

-- 6. Persons
INSERT INTO persons (id, person_code, canonical_name, age_years, gender, primary_role, risk_level, phone, address, identifier_ref, known_locations, socio_demographics, behavioral_profile, last_activity) VALUES
(1001, 'P-1001', 'Ravi Kumar S', 34, 'M', 'accused', 'high', '+91 98xx xx4821', 'BTM Layout 2nd Stage, Bengaluru', 'AAD-XXXX-8821', '["BTM Layout", "Madiwala Market", "Hosur Road"]'::jsonb, '{"occupation": "Unemployed (Former Auto Driver)", "educationLevel": "Secondary School (SSLC)", "incomeBracket": "Low Income (< ₹1.5L/year)", "originDistrict": "Mandya", "familyLinksCount": 3, "economicRiskFactor": "High"}'::jsonb, '{"modusOperandiSignature": "Night Burglary & Two-Wheeler Theft using Master Keys; targets unmanned residential parking 02:00-04:00 AM.", "recidivismScore": 84, "violencePropensity": "Medium", "communicationFingerprint": "Frequent burner SIM switching after crimes; 14 contacts identified in network graph.", "accompliceRiskIndex": 91}'::jsonb, '2026-07-21 18:40:00+05:30'),
(1002, 'P-1002', 'Faisal Ahmed', 27, 'M', 'suspect', 'high', '+91 97xx xx1174', 'Shivajinagar, Bengaluru', 'DL-KA01-XX7742', '["Shivajinagar", "KR Market"]'::jsonb, '{"occupation": "Scrap Dealer Assistant", "educationLevel": "Higher Secondary (PUC)", "incomeBracket": "Low Income (< ₹2L/year)", "originDistrict": "Bengaluru Urban", "familyLinksCount": 4, "economicRiskFactor": "High"}'::jsonb, '{"modusOperandiSignature": "Fencing stolen vehicle parts & altered chassis numbers; rapid liquidation within 48 hours.", "recidivismScore": 76, "violencePropensity": "Low", "communicationFingerprint": "Encrypted message groups & UPI micro-transactions to accomplices.", "accompliceRiskIndex": 82}'::jsonb, '2026-07-22 09:15:00+05:30'),
(1003, 'P-1003', 'Manju Nayak', 41, 'M', 'suspect', 'medium', '+91 96xx xx9080', 'Yeshwanthpur, Bengaluru', 'AAD-XXXX-1290', '["Yeshwanthpur", "Peenya Industrial Area"]'::jsonb, NULL, NULL, '2026-07-19 22:05:00+05:30'),
(1004, 'P-1004', 'Lakshmi Devi', 52, 'F', 'complainant', 'low', '+91 99xx xx3356', 'Jayanagar 4th Block, Bengaluru', 'AAD-XXXX-5567', '["Jayanagar"]'::jsonb, NULL, NULL, '2026-07-18 11:30:00+05:30'),
(1005, 'P-1005', 'Arjun Shetty', 29, 'M', 'witness', 'low', '+91 98xx xx7714', 'Koramangala 5th Block, Bengaluru', 'PAN-XXXXX331K', '["Koramangala"]'::jsonb, NULL, NULL, '2026-07-20 16:00:00+05:30'),
(1006, 'P-1006', 'Sunitha Rao', 36, 'F', 'victim', 'low', '+91 95xx xx2210', 'Malleshwaram, Bengaluru', 'AAD-XXXX-9034', '["Malleshwaram"]'::jsonb, NULL, NULL, '2026-07-17 14:20:00+05:30'),
(1007, 'P-1007', 'Imran Pasha', 45, 'M', 'accused', 'high', '+91 90xx xx6645', 'Frazer Town, Bengaluru', 'DL-KA03-XX2210', '["Frazer Town", "Shivajinagar", "Hosur Road"]'::jsonb, NULL, NULL, '2026-07-22 20:45:00+05:30'),
(1008, 'P-1008', 'Deepa Hegde', 31, 'F', 'complainant', 'low', '+91 91xx xx8890', 'Indiranagar, Bengaluru', 'AAD-XXXX-4412', '["Indiranagar"]'::jsonb, NULL, NULL, '2026-07-21 10:05:00+05:30')
ON CONFLICT (id) DO NOTHING;

-- Aliases
INSERT INTO person_aliases (person_id, alias_name) VALUES
(1001, 'Ravi Anna'),
(1001, 'RK'),
(1002, 'Chotu'),
(1003, 'Manja'),
(1005, 'AJ'),
(1007, 'Bhai')
ON CONFLICT DO NOTHING;

-- Case Parties (FIR <-> Person links)
INSERT INTO case_parties (fir_id, person_id, role, notes) VALUES
(101, 1001, 'accused', 'Primary suspect identified via CCTV and CDR'),
(101, 1002, 'suspect', 'Pillion rider seen fleeing scene'),
(101, 1004, 'complainant', 'Chain snatching victim and complainant'),
(102, 1001, 'accused', 'Linked by vehicle seen near burglary window'),
(102, 1005, 'witness', 'Neighbour statement on incident timing'),
(102, 1008, 'complainant', 'House owner and complainant'),
(103, 1002, 'suspect', 'Fencing organizer'),
(103, 1003, 'suspect', 'Co-accused in vehicle syndicate'),
(103, 1006, 'victim', 'Car owner'),
(104, 1001, 'accused', 'Extortion collection associate'),
(104, 1003, 'suspect', 'Collector'),
(104, 1007, 'accused', 'Syndicate operator and master account holder'),
(105, 1007, 'accused', 'Cargo pilferage handler')
ON CONFLICT DO NOTHING;

-- Person Relationships (Graph links)
INSERT INTO person_relationships (person_id, related_person_id, relationship_label, fir_reference_id, is_verified) VALUES
(1001, 1002, 'Associate — co-accused', 101, true),
(1002, 1001, 'Associate — co-accused', 101, true),
(1002, 1003, 'Seen together (CCTV)', 103, true),
(1003, 1002, 'Seen together (CCTV)', 103, true),
(1001, 1007, 'Financial link (transfers)', 104, false),
(1007, 1001, 'Financial link (transfers)', 104, false)
ON CONFLICT DO NOTHING;

-- 7. Evidence
INSERT INTO evidence (id, evidence_code, fir_id, label, evidence_type, status, collected_by, collected_at, location_description) VALUES
(701, 'E-701', 101, 'CCTV footage — market entrance (18:22–18:41)', 'cctv', 'verified', 'HC Prakash N', '2026-07-15 20:10:00+05:30', 'Jayanagar 4th Block Market'),
(702, 'E-702', 101, 'Recovered mobile phone (Redmi 12, IMEI ...8842)', 'physical', 'in-analysis', 'PSI Divya R', '2026-07-16 11:35:00+05:30', 'BTM Layout residence'),
(703, 'E-703', 101, 'Call detail records — +91 98xx xx4821 (30 days)', 'digital', 'verified', 'Cyber Cell', '2026-07-17 09:00:00+05:30', 'CDR request #4471'),
(704, 'E-704', 101, 'Complainant statement — Lakshmi Devi', 'document', 'verified', 'Insp. Meera Kulkarni', '2026-07-15 19:05:00+05:30', 'Jayanagar PS'),
(705, 'E-705', 102, 'Fingerprint lift — window grille', 'biological', 'in-analysis', 'FSL Team B', '2026-07-18 08:40:00+05:30', 'Indiranagar residence'),
(706, 'E-706', 103, 'CCTV footage — KR Market gate (02:10–02:26)', 'cctv', 'verified', 'HC Prakash N', '2026-07-12 10:20:00+05:30', 'KR Market West Gate'),
(707, 'E-707', 104, 'UPI transaction trail — 14 transfers', 'digital', 'in-analysis', 'Cyber Cell', '2026-07-19 15:30:00+05:30', 'Bank RTGS ref #99120'),
(708, 'E-708', 104, 'Seized ledger book (42 pages)', 'document', 'collected', 'PSI Divya R', '2026-07-20 17:55:00+05:30', 'Peenya godown')
ON CONFLICT (id) DO NOTHING;

-- 8. Vehicles
INSERT INTO vehicles (id, registration_number, make, model, color, registered_owner) VALUES
(501, 'KA-01-MJ-4482', 'Bajaj', 'Pulsar 150', 'Black', 'Ravi Kumar S'),
(502, 'KA-05-HT-9921', 'Maruti', 'Swift', 'White', 'Sunitha Rao'),
(503, 'KA-03-EQ-1104', 'Tata', 'Ace', 'Yellow', 'Imran Pasha'),
(504, 'KA-05-NB-8821', 'Hyundai', 'Verna', 'Black', 'Faisal Ahmed')
ON CONFLICT (registration_number) DO NOTHING;

INSERT INTO fir_vehicles (fir_id, vehicle_id) VALUES
(101, 501),
(102, 501),
(103, 502),
(104, 503)
ON CONFLICT DO NOTHING;

-- 9. Locations
INSERT INTO location_records (id, location_code, name, area, district, latitude, longitude) VALUES
(301, 'L-301', 'Jayanagar 4th Block Market', 'Jayanagar', 'Bengaluru City', 12.9304, 77.5835),
(302, 'L-302', 'Madiwala Market Junction', 'Madiwala', 'Bengaluru City', 12.9226, 77.6174),
(303, 'L-303', 'KR Market West Gate', 'KR Market', 'Bengaluru City', 12.9657, 77.5762),
(304, 'L-304', 'Peenya Industrial Area Ph-2', 'Peenya', 'Bengaluru City', 13.0285, 77.5197),
(305, 'L-305', 'Hosur Road Toll Plaza', 'Electronic City', 'Bengaluru City', 12.8452, 77.6602)
ON CONFLICT (id) DO NOTHING;

INSERT INTO fir_locations (fir_id, location_id) VALUES
(101, 301),
(101, 302),
(102, 302),
(103, 303),
(104, 304),
(104, 305),
(105, 305)
ON CONFLICT DO NOTHING;

-- 10. AI Findings
INSERT INTO ai_findings (id, finding_code, question, title, summary, confidence, status, risk, citations, related_fir_ids, related_person_ids, detected_relationships, generated_at, verified_by) VALUES
(1, 'AI-01', 'Are the Jayanagar snatching and Peenya extortion cases connected?', 'Financial link between F-2401 accused and Peenya lending racket', 'Ravi Kumar S (accused, FIR 0245/2026) received 4 UPI transfers totalling ₹48,500 from an account controlled by Imran Pasha (accused, FIR 0148/2026) within 10 days of the snatching incident. Timing and amounts are consistent with proceeds handling.', 0.820, 'pending', 'high', '[{"label": "UPI transaction trail — FIR 0148/2026", "excerpt": "Transfers #6, #9, #11, #14 -> account ...8821 (Ravi Kumar S)", "recordId": "E-707", "recordType": "evidence"}, {"label": "CDR — +91 98xx xx4821", "excerpt": "11 calls to +91 90xx xx6645 (Imran Pasha) between 15–19 Jul", "recordId": "E-703", "recordType": "evidence"}]'::jsonb, '["101", "104"]'::jsonb, '["1001", "1007"]'::jsonb, '["Ravi Kumar S <-> Imran Pasha (financial)", "FIR 0245/2026 <-> FIR 0148/2026 (proceeds trail)"]'::jsonb, '2026-07-22 21:05:00+05:30', NULL),
(2, 'AI-02', 'Does vehicle V-501 appear in other open cases?', 'Motorcycle KA-01-MJ-4482 linked to Indiranagar burglary window', 'The motorcycle registered to the F-2401 accused appears on street CCTV 400 m from the Indiranagar burglary scene at 01:40, inside the estimated incident window (01:30–02:30).', 0.740, 'verified', 'medium', '[{"label": "FIR 0232/2026 — CCTV canvass note", "excerpt": "Black Pulsar, partial plate KA-01-MJ-44xx at 01:40", "recordId": "102", "recordType": "fir"}, {"label": "CCTV — Jayanagar market", "excerpt": "Same vehicle, full plate visible at 18:24", "recordId": "E-701", "recordType": "evidence"}]'::jsonb, '["102", "101"]'::jsonb, '["1001"]'::jsonb, '["KA-01-MJ-4482 <-> FIR 0232/2026 (scene proximity)"]'::jsonb, '2026-07-21 10:15:00+05:30', 'PSI Divya R'),
(3, 'AI-03', 'Identify the second rider in the Jayanagar CCTV footage.', 'Pillion rider consistent with Faisal Ahmed', 'Gait and build analysis of the pillion rider is consistent with Faisal Ahmed, who co-occurs with Ravi Kumar S in prior case records. Facial identification is not possible from available footage.', 0.610, 'pending', 'medium', '[{"label": "CCTV — market entrance", "excerpt": "Pillion rider, 18:22:41–18:23:05", "recordId": "E-701", "recordType": "evidence"}, {"label": "Person record — Faisal Ahmed", "excerpt": "Known associate of Ravi Kumar S (FIR 0219/2026)", "recordId": "1002", "recordType": "person"}]'::jsonb, '["101"]'::jsonb, '["1002", "1001"]'::jsonb, '["Faisal Ahmed <-> FIR 0245/2026 (probable presence)"]'::jsonb, '2026-07-21 14:40:00+05:30', NULL),
(4, 'AI-04', 'Is the KR Market vehicle theft part of a pattern?', 'Three-theft pattern around KR Market with common suspects', 'Three vehicle thefts within 1.2 km of KR Market in six weeks share time-of-night (01:45–02:30), entry method, and two recurring individuals on CCTV. Pattern is consistent with an organised ring.', 0.880, 'verified', 'high', '[{"label": "CCTV — KR Market west gate", "excerpt": "Two persons, 02:10–02:26, matched across incidents", "recordId": "E-706", "recordType": "evidence"}, {"label": "FIR 0219/2026 — MO note", "excerpt": "Door-lock bypass identical to FIR 0187 and 0203", "recordId": "103", "recordType": "fir"}]'::jsonb, '["103"]'::jsonb, '["1002", "1003"]'::jsonb, '["FIR 0219/2026 <-> prior thefts (MO match)"]'::jsonb, '2026-07-19 11:50:00+05:30', 'Insp. Ramesh Gowda')
ON CONFLICT (id) DO NOTHING;

-- 11. Crime Hotspots
INSERT INTO crime_hotspots (id, hotspot_code, district, location_name, latitude, longitude, crime_count, dominant_crime_type, risk_level, peak_hours, predicted_trend) VALUES
(1, 'HS-01', 'Bengaluru City', 'Madiwala Market & Hosur Road Junction', 12.9226, 77.6174, 38, 'Night Vehicle Theft & Chain Snatching', 'critical', '01:00 AM – 04:30 AM', 'increasing'),
(2, 'HS-02', 'Bengaluru City', 'KR Market & Cottonpet Main Road', 12.9657, 77.5762, 29, 'Commercial Burglary & Pickpocketing', 'high', '05:00 PM – 09:00 PM', 'stable'),
(3, 'HS-03', 'Mysuru City', 'Devaraja Market & Bus Stand Corridor', 12.3087, 76.6531, 22, 'Tourist Pickpocketing & ATM Fraud', 'moderate', '11:00 AM – 03:00 PM', 'increasing'),
(4, 'HS-04', 'Hubballi-Dharwad City', 'Old Bus Stand Road & Lamington Road', 15.3647, 75.1240, 19, 'Two-Wheeler Theft Syndicate', 'high', '08:00 PM – 11:30 PM', 'decreasing'),
(5, 'HS-05', 'Belagavi City', 'Kirloskar Road & Khade Bazar', 15.8497, 74.5086, 16, 'Cyber SIM Spoofing & Financial Cheating', 'high', '10:00 AM – 06:00 PM', 'increasing')
ON CONFLICT (id) DO NOTHING;

-- 12. Predictive Early Warnings
INSERT INTO predictive_early_warnings (id, warning_code, title, description, district, risk_category, confidence, recommended_action, created_at) VALUES
(1, 'EW-901', 'Inter-district Two-Wheeler Theft Syndicate Active', 'AI Modus Operandi matcher detected identical master-key lock picking patterns in Bengaluru South & Mandya. High probability of cross-border fencing near Hosur border.', 'Bengaluru City / Mandya', 'Syndicate Movement', 0.920, 'Deploy midnight check-posts on NH-44 & alert Hosur Road police checkpoints.', '2026-07-25 08:30:00+05:30'),
(2, 'EW-902', 'Repeat Offender Release Spike Warning', '3 high-recidivism offenders (P-1001 linked network) released on bail within last 7 days. Historical data indicates 78% re-offence window within 14 days of release.', 'Bengaluru City', 'Recidivist Activity', 0.880, 'Issue Section 107 BNSS / CrPC preventive surveillance notices to station IOs.', '2026-07-24 16:45:00+05:30'),
(3, 'EW-903', 'Cyber OTP/UPI Impersonation Campaign Alert', 'Socio-demographic behavioral model flagged 18 complaints targeting senior citizens in Malleshwaram & Jayanagar via spoofed KSEB electricity bill SMS links.', 'Bengaluru City', 'Cyber Spike', 0.950, 'Broadcast public awareness alert via 1930 Cyber helpline & freeze identified mule accounts.', '2026-07-25 10:15:00+05:30')
ON CONFLICT (id) DO NOTHING;

-- 13. Proactive Patrol Routes
INSERT INTO proactive_patrol_routes (id, route_code, route_name, district, assigned_station, target_hotspots, optimal_time_window, efficiency_score, status) VALUES
(1, 'PR-101', 'Alpha Sector Midnight Patrol (BTM-Madiwala Belt)', 'Bengaluru City', 'Jayanagar PS & Madiwala PS', '["Madiwala Market", "Hosur Road Junction", "BTM 2nd Stage"]'::jsonb, '01:00 AM – 05:00 AM', 94, 'active'),
(2, 'PR-102', 'Bravo Commercial Corridor Patrol (KR Market - Cottonpet)', 'Bengaluru City', 'City Market PS', '["KR Market West Gate", "Cottonpet Main Road"]'::jsonb, '05:00 PM – 10:00 PM', 89, 'scheduled'),
(3, 'PR-103', 'Charlie Cyber & Financial Vulnerability Grid', 'Bengaluru City', 'Cyber Crime Police Station', '["Malleshwaram Banking Corridor", "Indiranagar Tech Parks"]'::jsonb, '10:00 AM – 04:00 PM', 91, 'active')
ON CONFLICT (id) DO NOTHING;

-- 14. Crime Pattern Clusters
INSERT INTO crime_pattern_clusters (id, cluster_code, pattern_name, category, affected_districts, fir_count, suspects_identified, mo_signature, risk_level, key_insight) VALUES
(1, 'CP-01', 'Organized Midnight Two-Wheeler Theft Network', 'Property Crime', '["Bengaluru City", "Mandya", "Ramanagara"]'::jsonb, 14, 5, 'Master key lock picking; target vehicle parked in dark residential lanes between 02:00 and 04:30 AM.', 'critical', 'AI pattern extraction links FIR-2026-0187 with 3 regional FIRs via identical key tool marks.'),
(2, 'CP-02', 'Elderly Utility Bill Impersonation Cyber Fraud', 'Cyber Financial Crime', '["Bengaluru City", "Mysuru City", "Belagavi City"]'::jsonb, 23, 4, 'Spoofed SMS warning power disconnection; remote screen control app installation via APK link.', 'high', 'Socio-demographic profiling indicates 82% of victims are retired citizens aged > 60 years.'),
(3, 'CP-03', 'Inter-State Fake Gold Loan Collateral Syndicate', 'Financial Impersonation', '["Hubballi-Dharwad City", "Vijayapura", "Belagavi City"]'::jsonb, 9, 3, 'Copper-core gold plated jewelry pledged at NBFC branches using forged Aadhaar cards.', 'high', 'Entity network graph detected shared mobile contacts between suspects in Belagavi and Hubballi.')
ON CONFLICT (id) DO NOTHING;

-- 15. Notifications
INSERT INTO notifications (id, user_id, title, body, kind, action_required, is_read, created_at) VALUES
(1, 1, 'AI finding awaiting verification', 'AI-01 links FIR 0245/2026 and FIR 0148/2026 through a financial trail (82% confidence). Review and verify against source records.', 'verification', true, false, '2026-07-22 21:06:00+05:30'),
(2, 1, 'Charge review due — FIR 0219/2026', 'ACP South Division requested charge review. Due within 48 hours.', 'deadline', true, false, '2026-07-22 16:21:00+05:30'),
(3, 1, 'New FIR assigned to your station', 'FIR 0251/2026 (Majestic snatching) registered at Upparpet PS and shared for pattern correlation.', 'assignment', false, false, '2026-07-22 19:36:00+05:30'),
(4, 1, 'FSL result expected', 'Fingerprint analysis for E-705 (FIR 0232/2026) expected by 24 Jul.', 'system', false, true, '2026-07-21 09:00:00+05:30'),
(5, 1, 'Escalation: repeat-offender alert', 'Ravi Kumar S now linked to 3 open FIRs. Supervisor notified per policy.', 'escalation', true, true, '2026-07-21 14:50:00+05:30')
ON CONFLICT (id) DO NOTHING;

-- 16. Audit Logs
INSERT INTO audit_logs (id, user_id, actor_name, actor_role, action, target_description, target_type, detail, timestamp) VALUES
(1, 1, 'AI Investigator', 'System', 'Generated finding', 'AI-01 — Financial link F-2401 ↔ F-2296', 'ai-finding', 'Confidence 82%. Queued for human verification.', '2026-07-22 21:05:00+05:30'),
(2, 2, 'Insp. Meera Kulkarni', 'Investigating Officer', 'Updated FIR', 'FIR 0148/2026', 'fir', 'Added financial analysis memo to case file.', '2026-07-22 20:50:00+05:30'),
(3, 3, 'Insp. Ramesh Gowda', 'Investigating Officer', 'Created FIR', 'FIR 0251/2026', 'fir', 'Mobile phone snatching — Majestic bus stand.', '2026-07-22 19:35:00+05:30'),
(4, 2, 'PSI Divya R', 'Sub-Inspector', 'Linked evidence', 'E-702 → FIR 0245/2026', 'evidence', 'Recovered mobile phone sent for IMEI analysis.', '2026-07-22 18:10:00+05:30'),
(5, 1, 'ACP South Division', 'Supervisor', 'Requested review', 'FIR 0219/2026', 'fir', 'Charge review requested with priority.', '2026-07-22 16:20:00+05:30')
ON CONFLICT (id) DO NOTHING;

-- Reset sequence values
SELECT setval('roles_id_seq', (SELECT MAX(id) FROM roles));
SELECT setval('police_stations_id_seq', (SELECT MAX(id) FROM police_stations));
SELECT setval('officers_id_seq', (SELECT MAX(id) FROM officers));
SELECT setval('users_id_seq', (SELECT MAX(id) FROM users));
SELECT setval('firs_id_seq', (SELECT MAX(id) FROM firs));
SELECT setval('persons_id_seq', (SELECT MAX(id) FROM persons));
SELECT setval('evidence_id_seq', (SELECT MAX(id) FROM evidence));
SELECT setval('vehicles_id_seq', (SELECT MAX(id) FROM vehicles));
SELECT setval('location_records_id_seq', (SELECT MAX(id) FROM location_records));
SELECT setval('ai_findings_id_seq', (SELECT MAX(id) FROM ai_findings));
SELECT setval('crime_hotspots_id_seq', (SELECT MAX(id) FROM crime_hotspots));
SELECT setval('predictive_early_warnings_id_seq', (SELECT MAX(id) FROM predictive_early_warnings));
SELECT setval('proactive_patrol_routes_id_seq', (SELECT MAX(id) FROM proactive_patrol_routes));
SELECT setval('crime_pattern_clusters_id_seq', (SELECT MAX(id) FROM crime_pattern_clusters));
SELECT setval('notifications_id_seq', (SELECT MAX(id) FROM notifications));
SELECT setval('audit_logs_id_seq', (SELECT MAX(id) FROM audit_logs));
