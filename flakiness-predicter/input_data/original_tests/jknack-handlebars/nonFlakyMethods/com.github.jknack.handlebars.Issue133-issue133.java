@Test public void issue133() throws IOException {
  shouldCompileTo("{{times nullvalue 3}}",$("nullvalue",null),"");
  shouldCompileTo("{{times nullvalue 3}}",$("nullvalue","a"),"aaa");
}
