/** 
 * @see <a href="https://issues.apache.org/jira/browse/OAK-1697">OAK-1697</a>
 */
@Test public void testValidTokenCredentialsWithConflict() throws Exception {
  ExecutorService pool=Executors.newFixedThreadPool(10);
  List<ContentSession> sessions=new ArrayList<ContentSession>();
  try {
    TokenConfiguration tc=getSecurityProvider().getConfiguration(TokenConfiguration.class);
    SimpleCredentials sc=(SimpleCredentials)getAdminCredentials();
    List<TokenProvider> tokenProviders=new ArrayList<TokenProvider>();
    for (int i=0; i < 10; i++) {
      ContentSession session=login(getAdminCredentials());
      Root r=session.getLatestRoot();
      tokenProviders.add(tc.getTokenProvider(r));
      sessions.add(session);
    }
    ArrayList<DataFuture> list=new ArrayList<DataFuture>();
    for (    TokenProvider tokenProvider : tokenProviders) {
      list.add(createDataFuture(pool,tokenProvider,sc.getUserID(),Collections.<String,Object>emptyMap()));
    }
    for (    DataFuture df : list) {
      assertNotNull(df.future.get());
    }
  }
  finally {
    for (    ContentSession session : sessions) {
      if (session != null) {
        session.close();
      }
    }
    if (pool != null) {
      pool.shutdown();
    }
  }
}
