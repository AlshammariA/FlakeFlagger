@Test public void testVCardFullN(){
  doTest("BEGIN:VCARD\r\nVERSION:2.1\r\nN:Owen;Sean;T;Mr.;Esq.\r\nEND:VCARD",null,new String[]{"Mr. Sean T Owen Esq."},null,null,null,null,null,null,null,null);
}
