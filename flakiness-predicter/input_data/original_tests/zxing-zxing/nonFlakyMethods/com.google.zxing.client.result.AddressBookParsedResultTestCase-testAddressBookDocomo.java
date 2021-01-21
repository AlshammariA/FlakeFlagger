@Test public void testAddressBookDocomo(){
  doTest("MECARD:N:Sean Owen;;",null,new String[]{"Sean Owen"},null,null,null,null,null,null,null,null);
  doTest("MECARD:NOTE:ZXing Team;N:Sean Owen;URL:google.com;EMAIL:srowen@example.org;;",null,new String[]{"Sean Owen"},null,null,new String[]{"srowen@example.org"},null,null,new String[]{"google.com"},null,"ZXing Team");
}
