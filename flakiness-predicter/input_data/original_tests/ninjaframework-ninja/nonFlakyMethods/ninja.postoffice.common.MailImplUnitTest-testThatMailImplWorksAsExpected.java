@Test public void testThatMailImplWorksAsExpected(){
  Mail mail=MailImplTestHelper.getMailImplWithDemoContent();
  MailImpl mailImpl=(MailImpl)mail;
  assertTrue(mailImpl.getSubject().equals("subject"));
  assertTrue(mailImpl.getFrom().contains("from1@domain"));
  assertTrue(mailImpl.getReplyTo().contains("replyTo1@domain"));
  assertTrue(mailImpl.getReplyTo().contains("replyTo2@domain"));
  mail.setCharset("utf-8");
  assertTrue(mailImpl.getCharset().contains("utf-8"));
  assertTrue(mailImpl.getHeaders().get("header1").equals("value1"));
  assertTrue(mailImpl.getHeaders().get("header2").equals("value2"));
  assertTrue(mailImpl.getTos().contains("to1@domain"));
  assertTrue(mailImpl.getTos().contains("to2@domain"));
  assertTrue(mailImpl.getCcs().contains("cc1@domain"));
  assertTrue(mailImpl.getCcs().contains("cc2@domain"));
  assertTrue(mailImpl.getBccs().contains("bcc1@domain"));
  assertTrue(mailImpl.getBccs().contains("bcc2@domain"));
  assertTrue(mailImpl.getBodyText().equals("bodyText"));
  assertTrue(mailImpl.getBodyHtml().equals("bodyHtml"));
}
