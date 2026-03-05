# Anforderungsanalyse – Event-Management-System

## 1. Einleitung
Dieses Dokument beschreibt die vollständige Anforderungsanalyse für ein webbasiertes Event-Management-System.
Ziel ist eine klare, testbare Spezifikation als Grundlage für Domänenmodell (UML), API-Design und Implementierung.

---

## 2. Ziel des Systems
Das System soll:
- Events verwalten (CRUD)
- Mitarbeitende verwalten (CRUD)
- Mitarbeitende Events zuordnen
- Teilnehmerlisten pro Event bereitstellen

---

## 3. Stakeholder
| Stakeholder | Beschreibung |
|-------------|--------------|
| Administrator | Verwaltet Events und Mitarbeitende |
| Mitarbeitende | Können Events zugeordnet werden |
| Entwickler | Implementiert und wartet das System |

---

## 4. Priorisierung (MoSCoW)

### 4.1 Regeln zur Priorisierung
- **Must** = nötig, damit das System „funktioniert“ (Minimum Viable System)
- **Should** = sehr wichtig, aber System wäre notfalls ohne noch nutzbar
- **Could** = nice-to-have
- **Won’t (now)** = bewusst nicht im Scope (für spätere Iteration)

---

## 5. Funktionale Anforderungen (FR)

> Format: **FRx (Prio: …)**

### Event-Verwaltung
**FR1 (Prio: Must) – Event anlegen**  
Das System muss das Anlegen eines neuen Events ermöglichen.

**FR2 (Prio: Must) – Event anzeigen**  
Das System muss spezifische Events und deren Eigenschaften anzeigen können.

**FR3 (Prio: Must) – Alle Events anzeigen**  
Das System muss alle angelegten Events und deren Eigenschaften anzeigen können.

**FR4 (Prio: Must) – Event aktualisieren**  
Das System muss die Eigenschaften bereits bestehender Events bearbeiten können.

**FR5 (Prio: Must) – Event löschen**  
Das System muss bereits bestehende Events entfernen können.

### Mitarbeiter-Verwaltung
**FR6 (Prio: Must) – Mitarbeiter anlegen**  
Das System muss das Anlegen eines neuen Mitarbeiters ermöglichen.

**FR7 (Prio: Must) – Mitarbeiter anzeigen**  
Das System muss spezifische Mitarbeiter und deren Eigenschaften anzeigen können.

**FR8 (Prio: Must) – Alle Mitarbeiter anzeigen**  
Das System muss alle Mitarbeiter und deren Eigenschaften anzeigen können.

**FR9 (Prio: Must) – Mitarbeiter aktualisieren**  
Das System muss die Eigenschaften bereits bestehender Mitarbeiter bearbeiten können.

**FR10 (Prio: Should) – Mitarbeiter löschen**  
Das System sollte bereits bestehende Mitarbeiter entfernen können.

### Zuordnung Mitarbeiter ↔ Event
**FR11 (Prio: Must) – Mitarbeiter zu Event hinzufügen**  
Das System muss Mitarbeiter zu einem Event hinzufügen können.

**FR12 (Prio: Must) – Mitarbeiter von Event entfernen**  
Das System muss Mitarbeiter von einem Event entfernen können.

**FR13 (Prio: Must) – Teilnehmerliste anzeigen**  
Das System muss alle Mitarbeitenden anzeigen können, die an einem bestimmten Event teilnehmen.

**FR14 (Prio: Should) – Maximale Teilnehmerzahl berücksichtigen**  
Das System sollte verhindern, dass mehr Mitarbeitende zu einem Event hinzugefügt werden als die maximal erlaubte Teilnehmerzahl.

---

## 6. Geschäftsregeln (GR)

**GR1 – Datensatzintegrität**  
Mitarbeiter und Events können nicht ohne Namen angelegt werden.

**GR2 – Maximale Teilnehmerzahl**  
Ein Event besitzt eine maximale Teilnehmerzahl. Diese darf nicht überschritten werden.

**GR3 – Anmeldung nur für zukünftige Events**  
Mitarbeiter können nur für Events eingetragen werden, die noch nicht stattgefunden haben.

**GR4 – Zuordnung**  
Ein Mitarbeiter kann an mehreren Events teilnehmen.

---

## 7. Nicht-funktionale Anforderungen (NFR)

> Format: **NFRx (Prio: …)**

**NFR1 (Prio: Should) – Performance**  
API-Anfragen sollen innerhalb von maximal 2 Sekunden beantwortet werden.

**NFR2 (Prio: Should) – Skalierbarkeit**  
Das System soll mindestens 100 gleichzeitige Nutzer unterstützen.

**NFR3 (Prio: Must) – Wartbarkeit/Struktur**  
Der Code muss modular aufgebaut sein und eine klare Schichtenarchitektur aufweisen.

**NFR4 (Prio: Should) – Sicherheit**  
Nur autorisierte Benutzer dürfen Änderungen an Events oder Mitarbeitenden durchführen.

**NFR5 (Prio: Must) – API-Standardisierung**  
Die API muss REST-konform gestaltet sein.

**NFR6 (Prio: Must) – Dokumentation**  
Die API muss mithilfe von OpenAPI / Swagger dokumentiert werden.
