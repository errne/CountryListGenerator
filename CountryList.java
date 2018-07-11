package com.errne.countrylistgenerator;

public class CountryList {
    static final String[] EUROPE = {"Albania", "Andorra", "Armenia", "Austria", "Azerbaijan", "Belarus", "Belgium", "Bosnia and Herzegovina", "Bulgaria", "Croatia",
            "Cyprus", "Czechia", "Denmark", "England", "Estonia", "Faroe Islands","Finland", "France", "Georgia", "Germany", "Greece", "Hungary", "Iceland", "Ireland", "Italy", "Kosovo", "Latvia",
            "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Malta", "Moldova", "Montenegro", "The Netherlands","Northern Ireland", "Norway", "Poland", "Portugal", "Romania",
            "Russia", "San Marino","Scotland", "Serbia", "Slovakia", "Slovenia", "Spain", "Sweden", "Switzerland", "Turkey", "Wales", "Ukraine"};
    static final String[] ASIA = {"Yemen", "Vietnam", "Uzbekistan", "United Arab Emirates", "Turkmenistan", "Thailand", "Tajikistan", "Syria", "Palestine", "Sri Lanka",
            "South Korea", "Singapore", "Saudi Arabia", "Qatar", "Philippines", "Pakistan", "Oman", "Northern Mariana Islands", "North Korea", "Nepal", "Myanmar", "Mongolia",
            "Maldives", "Malaysia", "Macau", "Lebanon", "Laos", "Kyrgyzstan", "Kuwait", "Jordan", "Japan", "Iraq", "Iran", "Indonesia", "India", "Hong Kong", "Guam",
            "East Timor", "Taiwan", "China", "Cambodia", "Brunei", "Bhutan", "Bangladesh", "Bahrain", "Afghanistan", "Kazakhstan", "Israel", };
    static final String[] AFRICA = {"Algeria", "Angola", "Benin", "Botswana", "Burkina Faso", "Burundi", "Cameroon", "Cape Verde", "Central African Republic", "Chad", "Comoros", "DR Congo", "Djibouti",
            "Egypt", "Equatorial Guinea", "Eritrea", "Ethiopia", "Gabon", "Ghana", "Guinea", "Guinea-Bissau", "Ivory Coast", "Kenya", "Lesotho", "Liberia", "Libya", "Madagascar", "Malawi",
            "Mali", "Mauritania", "Mauritius", "Morocco", "Mozambique", "Namibia", "Niger", "Nigeria", "Congo", "Rwanda", "Réunion", "Senegal", "Seychelles", "Sierra Leone", "Somalia",
            "South Africa", "South Sudan", "Sudan", "Swaziland", "São Tomé and Príncipe", "Tanzania", "Gambia", "Togo", "Tunisia", "Uganda", "Zambia", "Zanzibar", "Zimbabwe"};
    static final String[] OCEANIA = {"Australia", "Cook Islands","Fiji","Kiribati","New Caledonia","New Zealand","Papua New Guinea","Samoa","Solomon Islands","Tahiti", "Tonga","Tuvalu","Vanuatu"};
    static final String[] NAMERICA = {"Canada", "Mexico", "United States", "Belize", "Costa Rica", "El Salvador", "Guatemala", "Honduras", "Nicaragua", "Panama", "Anguilla", "Antigua and Barbuda",
            "Aruba", "Bahamas", "Barbados", "Bermuda", "Bonaire", "Virgin Islands", "Cayman Islands", "Cuba", "Curaçao", "Dominica", "Dominican Republic", "French Guiana",
            "Grenada", "Guadeloupe", "Haiti", "Jamaica", "Martinique", "Montserrat", "Puerto Rico", "Saint Kitts and Nevis", "Saint Lucia", "Saint Martin",
            "Saint Vincent and the Grenadines", "Sint Maarten", "Trinidad and Tobago", "Turks and Caicos Islands"};
    static final String[] SAMERICA = {"Argentina", "Bolivia", "Brazil", "Chile"," Colombia", "Ecuador", "Guyana",
            "Paraguay", "Peru", "Suriname", "Uruguay", "Venezuela"};
    String[] countryList;
    int i;

    public CountryList(int nr){
        countryList = new String[nr];
        i=0;
    }

    public void addCountry(String country){
        if (i>countryList.length){
            return;
        }
        countryList[i] = country;
        i++;
    }

    public String[] getCountryList(){
        return countryList;
    }

}
