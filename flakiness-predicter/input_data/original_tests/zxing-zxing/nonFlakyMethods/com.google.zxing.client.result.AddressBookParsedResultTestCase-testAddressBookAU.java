@Test public void testAddressBookAU(){
  doTest("MEMORY:foo\r\nNAME1:Sean\r\nTEL1:+12125551212\r\n",null,new String[]{"Sean"},null,null,null,new String[]{"+12125551212"},null,null,null,"foo");
}
