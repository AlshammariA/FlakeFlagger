@Test public void testVCard(){
  doTest("BEGIN:VCARD\r\nADR;HOME:123 Main St\r\nVERSION:2.1\r\nN:Owen;Sean\r\nEND:VCARD",null,new String[]{"Sean Owen"},null,new String[]{"123 Main St"},null,null,null,null,null,null);
}
