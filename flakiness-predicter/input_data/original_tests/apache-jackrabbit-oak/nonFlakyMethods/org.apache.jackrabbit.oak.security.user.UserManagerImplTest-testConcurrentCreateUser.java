@Test public void testConcurrentCreateUser() throws Exception {
  final List<Exception> exceptions=new ArrayList<Exception>();
  List<Thread> workers=new ArrayList<Thread>();
  for (int i=0; i < 10; i++) {
    final String userId="foo-user-" + i;
    workers.add(new Thread(new Runnable(){
      public void run(){
        try {
          ContentSession admin=login(getAdminCredentials());
          Root root=admin.getLatestRoot();
          UserManager userManager=new UserManagerImpl(root,namePathMapper,getSecurityProvider());
          userManager.createUser(userId,"pass");
          root.commit();
          admin.close();
        }
 catch (        Exception e) {
          exceptions.add(e);
        }
      }
    }
));
  }
  for (  Thread t : workers) {
    t.start();
  }
  for (  Thread t : workers) {
    t.join();
  }
  for (  Exception e : exceptions) {
    e.printStackTrace();
  }
  if (!exceptions.isEmpty()) {
    throw exceptions.get(0);
  }
}
