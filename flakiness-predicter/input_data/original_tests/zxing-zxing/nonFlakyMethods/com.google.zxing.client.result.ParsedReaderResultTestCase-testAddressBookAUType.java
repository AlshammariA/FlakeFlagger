@Test public void testAddressBookAUType(){
  doTestResult("MEMORY:\r\n","",ParsedResultType.ADDRESSBOOK);
  doTestResult("MEMORY:foo\r\nNAME1:Sean\r\n","Sean\nfoo",ParsedResultType.ADDRESSBOOK);
  doTestResult("TEL1:+12125551212\r\nMEMORY:\r\n","+12125551212",ParsedResultType.ADDRESSBOOK);
}
