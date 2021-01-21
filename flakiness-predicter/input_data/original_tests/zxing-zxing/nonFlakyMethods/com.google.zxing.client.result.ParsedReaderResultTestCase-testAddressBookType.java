@Test public void testAddressBookType(){
  doTestResult("MECARD:N:Sean Owen;;","Sean Owen",ParsedResultType.ADDRESSBOOK);
  doTestResult("MECARD:TEL:+12125551212;N:Sean Owen;;","Sean Owen\n+12125551212",ParsedResultType.ADDRESSBOOK);
  doTestResult("MECARD:TEL:+12125551212;N:Sean Owen;URL:google.com;;","Sean Owen\n+12125551212\ngoogle.com",ParsedResultType.ADDRESSBOOK);
  doTestResult("MECARD:TEL:+12125551212;N:Sean Owen;URL:google.com;EMAIL:srowen@example.org;","Sean Owen\n+12125551212\nsrowen@example.org\ngoogle.com",ParsedResultType.ADDRESSBOOK);
  doTestResult("MECARD:ADR:76 9th Ave;N:Sean Owen;URL:google.com;EMAIL:srowen@example.org;","Sean Owen\n76 9th Ave\nsrowen@example.org\ngoogle.com",ParsedResultType.ADDRESSBOOK);
  doTestResult("MECARD:BDAY:19760520;N:Sean Owen;URL:google.com;EMAIL:srowen@example.org;","Sean Owen\nsrowen@example.org\ngoogle.com\n19760520",ParsedResultType.ADDRESSBOOK);
  doTestResult("MECARD:ORG:Google;N:Sean Owen;URL:google.com;EMAIL:srowen@example.org;","Sean Owen\nGoogle\nsrowen@example.org\ngoogle.com",ParsedResultType.ADDRESSBOOK);
  doTestResult("MECARD:NOTE:ZXing Team;N:Sean Owen;URL:google.com;EMAIL:srowen@example.org;","Sean Owen\nsrowen@example.org\ngoogle.com\nZXing Team",ParsedResultType.ADDRESSBOOK);
  doTestResult("N:Sean Owen;TEL:+12125551212;;","N:Sean Owen;TEL:+12125551212;;",ParsedResultType.TEXT);
}
