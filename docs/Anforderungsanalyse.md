### Funktionale Anforderungen
1. **Event anlegen**: Das System muss das Anlegen eines neuen Events ermöglichen.
2. **Event anzeigen**: Das System muss Events und deren Eigenschaften anzeigen können
3. **Event aktualisieren**: Das System muss die Eigenschaften bereits bestehende Events bearbeiten können 
4. **Event löschen**: Das System muss bereits bestehende Events wieder entfernen können
5. **Mitarbeiter anlegen**: Das System muss das Anlegen eines neuen Mitarbeiters ermöglichen.
6. **Mitarbeiter anzeigen**: Das System muss Mitarbeiter und deren Eigenschaften anzeigen können
7. **Mitarbeiter löschen**: Das System muss bereits bestehende Mitarbeiter wieder entfernen können
8. **Mitarbeiter zu Event hinzufügen**: Das System muss Mitarbeiter zu einem Event hinzufügen können
9. **Mitarbeiter von einem Event entfernen**: Das System muss Mitarbeiter von einem Event entfernen können.
10. **Teilnehmerliste anzeigen**: Das System muss alle an einem Event teilnehmenden Mitarbeiter anzeigen können
11. 


### Nicht-Funktionale Anforderungen
1. **


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
Das System muss Events und deren Eigenschaften anzeigen können.

**FR3 (Prio: Must) – Event aktualisieren**  
Das System muss die Eigenschaften bereits bestehender Events bearbeiten können.

**FR4 (Prio: Must) – Event löschen**  
Das System muss bereits bestehende Events entfernen können.

### Mitarbeiter-Verwaltung
**FR5 (Prio: Must) – Mitarbeiter anlegen**  
Das System muss das Anlegen eines neuen Mitarbeiters ermöglichen.

**FR6 (Prio: Must) – Mitarbeiter anzeigen**  
Das System muss Mitarbeiter und deren Eigenschaften anzeigen können.

**FR7 (Prio: Should) – Mitarbeiter löschen**  
Das System sollte bereits bestehende Mitarbeiter entfernen können.

### Zuordnung Mitarbeiter ↔ Event
**FR8 (Prio: Must) – Mitarbeiter zu Event hinzufügen**  
Das System muss Mitarbeiter zu einem Event hinzufügen können.

**FR9 (Prio: Must) – Mitarbeiter von Event entfernen**  
Das System muss Mitarbeiter von einem Event entfernen können.

**FR10 (Prio: Must) – Teilnehmerliste anzeigen**  
Das System muss alle Mitarbeitenden anzeigen können, die an einem bestimmten Event teilnehmen.

**FR11 (Prio: Should) – Maximale Teilnehmerzahl berücksichtigen**  
Das System sollte verhindern, dass mehr Mitarbeitende zu einem Event hinzugefügt werden als die maximal erlaubte Teilnehmerzahl.

---

## 6. Geschäftsregeln (GR)

**GR1 – Maximale Teilnehmerzahl**  
Ein Event besitzt eine maximale Teilnehmerzahl. Diese darf nicht überschritten werden.

**GR2 – Eindeutige Identifikation**  
Jedes Event und jeder Mitarbeiter muss eine eindeutige ID besitzen.

**GR3 – Zuordnung**  
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

**NFR4 (Prio: Must) – Sicherheit**  
Nur autorisierte Benutzer dürfen Änderungen an Events oder Mitarbeitenden durchführen.

**NFR5 (Prio: Must) – API-Standardisierung**  
Die API muss REST-konform gestaltet sein.

**NFR6 (Prio: Could) – Dokumentation**  
Die API sollte mithilfe von OpenAPI / Swagger dokumentiert werden.

---

## 8. Qualitätsmerkmale guter Anforderungen
Eine Anforderung soll:
- eindeutig
- atomar
- testbar
- vollständig
- konsistent
- lösungsneutral  
  sein.

---

## 9. Abgrenzung
- **Domänenmodell (UML):** fachliche Struktur (Klassen, Attribute, Beziehungen)
- **API-Design:** REST-Endpunkte + Methoden + Statuscodes basierend auf Anforderungen

---

## 10. Typische Fehler bei Anforderungen
- mehrere Anforderungen in einem Satz
- unklare Begriffe („schnell“, „intuitiv“)
- technische Lösungen statt fachliche Anforderungen
- fehlende Nummerierung / fehlende Testbarkeit
- Widersprüche

---

## 11. Zusammenfassung
Die Anforderungen (FR/NFR) sind nummeriert, priorisiert und bilden die Grundlage für UML-Domänenmodell und REST-API-Design.