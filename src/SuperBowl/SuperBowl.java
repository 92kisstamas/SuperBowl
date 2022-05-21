package SuperBowl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class SuperBowl {

    /*
    Ssz: A döntő sorszáma római számmal
    • Dátum: A döntő ideje
    • Győztes: A győztes csapat neve
    • Eredmény: A döntő végeredménye (győztes pontjai-vesztes pontjai)
    • Vesztes: A vesztes csapat neve
    • Helyszín: A döntő helyszíne (stadion)
    • VárosÁllam: A döntő városa és a város állama vesszővel elválasztva
    • Nézőszám: A nézők száma
    */

    private String serialNumber;
    private LocalDate date;
    private String winner;
    private String result;
    private String loser;
    private String venue;
    private String cityState;
    private int numberOfSpecators;


    public SuperBowl(String line) {
        String[] temp = line.split(";");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd.");
        formatter = formatter.withLocale(Locale.forLanguageTag(temp[1]));

        RomaiSorszam romaiSorszam = new RomaiSorszam(temp[0]);
        romaiSorszam.getArabSsz();

        this.serialNumber = romaiSorszam.getArabSsz();
        this.date = LocalDate.parse(temp[1], formatter);
        this.winner = temp[2];
        this.result = temp[3];
        this.loser = temp[4];
        this.venue = temp[5];
        this.cityState = temp[6];
        this.numberOfSpecators = Integer.parseInt(temp[7]);
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getLoser() {
        return loser;
    }

    public void setLoser(String loser) {
        this.loser = loser;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getCityState() {
        return cityState;
    }

    public void setCityState(String cityState) {
        this.cityState = cityState;
    }

    public int getNumberOfSpecators() {
        return numberOfSpecators;
    }

    public void setNumberOfSpecators(int numberOfSpecators) {
        this.numberOfSpecators = numberOfSpecators;
    }
}
