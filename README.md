# Bibliotetka

Projekt oferuje prosty interfejs do zarządzania książkami w bibliotece szkolnej. Użytkownik wpisuje swoje dane jako student, dane obejmują:imię, nazwisko i klasę (z ograniczeniem do jednej cyfry od 1 do 5). Projekt automatycznie poprawia wprowadzone imię i nazwisko, nadając pierwszej literze formę wielką, a pozostałym literom formę małą.

Po zarejestrowaniu studenta, użytkownik może przeglądać dostępne książki w bibliotece, wyświetlając ich tytuły, autorów, typy i dostępność. Projekt umożliwia wypożyczanie i zwracanie książek. Po wypożyczeniu książki, liczba dostępnych egzemplarzy danej książki zostaje zaktualizowana, a informacje o wypożyczonych książkach są dostępne dla studenta.

Dodatkowo, projekt zawiera przykładowe dane dla 20 książek, które mogą być modyfikowane lub rozszerzane. Wszystkie operacje są wykonywane w konsoli, a kod projektu stosuje poprawne konwencje nazewnicze, waliduje dane wejściowe, wykorzystuje dziedziczenie, enkapsulację, metody i pola statyczne i niestatyczne.

Opis do każdej klasy:
Klasa Book:

Klasa Book przechowuje informacje o każdej książce, takie jak tytuł, autor, typ i dostępność.
Oferuje metody umożliwiające zmniejszenie i zwiększenie liczby dostępnych egzemplarzy (decreaseAvailability, increaseAvailability).

Klasa Student:

Klasa Student przechowuje informacje o uczniu, takie jak imię, nazwisko, klasa i lista wypożyczonych książek.
Oferuje metody do wypożyczania i zwracania książek (borrowBook, returnBook).
Udostępnia metody dostępu do informacji o uczniu i jego wypożyczonych książkach.

Klasa Library:

Klasa Library zarządza książkami i uczniami w bibliotece.
Posiada listy obiektów klasy Book i Student, umożliwiające przechowywanie i manipulowanie danymi.
Udostępnia metody do dodawania książek i uczniów, wypożyczania i zwracania książek, wyświetlania dostępnych książek oraz wypożyczonych książek danego ucznia.
Zawiera dodatkową metodę displayBorrowedBooks, która wyświetla wypożyczone książki danego studenta.

Klasa Main:

Klasa Main zawiera funkcję główną, która obsługuje interakcję z użytkownikiem w konsoli.
Inicjalizuje obiekty klasy Library, dodaje przykładowe dane do książek, a także obsługuje dodawanie studenta i wywołuje funkcje biblioteki w zależności od wyboru użytkownika.
