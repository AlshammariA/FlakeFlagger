@Test public void testQuotedPrintable(){
  doTest("BEGIN:VCARD\r\nADR;HOME;CHARSET=UTF-8;ENCODING=QUOTED-PRINTABLE:;;" + "=38=38=20=4C=79=6E=62=72=6F=6F=6B=0D=0A=43=\r\n" + "=4F=20=36=39=39=\r\n"+ "=39=39;;;\r\nEND:VCARD",null,null,null,new String[]{"88 Lynbrook\r\nCO 69999"},null,null,null,null,null,null);
}
