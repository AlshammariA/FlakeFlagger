@Test public void verifyCustomPrivileges() throws Exception {
  JackrabbitSession session=createAdminSession();
  try {
    JackrabbitWorkspace workspace=(JackrabbitWorkspace)session.getWorkspace();
    PrivilegeManager manager=workspace.getPrivilegeManager();
    Privilege privilege=manager.getPrivilege("test:privilege");
    assertNotNull(privilege);
    assertFalse(privilege.isAbstract());
    assertFalse(privilege.isAggregate());
    assertEquals(0,privilege.getDeclaredAggregatePrivileges().length);
    Privilege aggregate=manager.getPrivilege("test:aggregate");
    assertNotNull(aggregate);
    assertFalse(aggregate.isAbstract());
    assertTrue(aggregate.isAggregate());
    assertEquals(2,aggregate.getDeclaredAggregatePrivileges().length);
  }
  finally {
    session.logout();
  }
}
