@Test public void testEscapedVCard(){
  doTest("BEGIN:VCARD\r\nADR;HOME:123\\;\\\\ Main\\, St\\nHome\r\nVERSION:2.1\r\nN:Owen;Sean\r\nEND:VCARD",null,new String[]{"Sean Owen"},null,new String[]{"123;\\ Main, St\nHome"},null,null,null,null,null,null);
}
