@Test public void testVCardFullN2(){
  doTest("BEGIN:VCARD\r\nVERSION:2.1\r\nN:Owen;Sean;;;\r\nEND:VCARD",null,new String[]{"Sean Owen"},null,null,null,null,null,null,null,null);
}
