@Test public void testVCardFullN3(){
  doTest("BEGIN:VCARD\r\nVERSION:2.1\r\nN:;Sean;;;\r\nEND:VCARD",null,new String[]{"Sean"},null,null,null,null,null,null,null,null);
}
