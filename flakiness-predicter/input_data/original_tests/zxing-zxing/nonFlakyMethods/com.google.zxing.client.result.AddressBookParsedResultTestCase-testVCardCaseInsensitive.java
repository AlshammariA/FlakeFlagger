@Test public void testVCardCaseInsensitive(){
  doTest("begin:vcard\r\nadr;HOME:123 Main St\r\nVersion:2.1\r\nn:Owen;Sean\r\nEND:VCARD",null,new String[]{"Sean Owen"},null,new String[]{"123 Main St"},null,null,null,null,null,null);
}
