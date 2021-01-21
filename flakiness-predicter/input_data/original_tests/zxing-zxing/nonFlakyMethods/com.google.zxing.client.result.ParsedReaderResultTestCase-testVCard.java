@Test public void testVCard(){
  doTestResult("BEGIN:VCARD\r\nEND:VCARD","",ParsedResultType.ADDRESSBOOK);
  doTestResult("BEGIN:VCARD\r\nN:Owen;Sean\r\nEND:VCARD","Sean Owen",ParsedResultType.ADDRESSBOOK);
  doTestResult("BEGIN:VCARD\r\nVERSION:2.1\r\nN:Owen;Sean\r\nEND:VCARD","Sean Owen",ParsedResultType.ADDRESSBOOK);
  doTestResult("BEGIN:VCARD\r\nADR;HOME:123 Main St\r\nVERSION:2.1\r\nN:Owen;Sean\r\nEND:VCARD","Sean Owen\n123 Main St",ParsedResultType.ADDRESSBOOK);
  doTestResult("BEGIN:VCARD","",ParsedResultType.ADDRESSBOOK);
}
