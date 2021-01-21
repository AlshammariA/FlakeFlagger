@Test public void testSetPropertyDateWithTimeZone() throws RepositoryException {
  Session session=getAdminSession();
  Node root=session.getRootNode();
  final Calendar cal=Calendar.getInstance();
  cal.setTimeZone(TimeZone.getTimeZone("America/Chicago"));
  cal.setTimeInMillis(1239902100000L);
  root.setProperty("start",cal);
  session.save();
  assertEquals(12,root.getProperty("start").getDate().get(Calendar.HOUR_OF_DAY));
  root.getProperty("start").remove();
  session.save();
}
