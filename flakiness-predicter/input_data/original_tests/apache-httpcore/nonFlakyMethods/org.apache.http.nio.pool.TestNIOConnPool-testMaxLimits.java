@Test public void testMaxLimits() throws Exception {
  IOSession iosession1=Mockito.mock(IOSession.class);
  SessionRequest sessionRequest1=Mockito.mock(SessionRequest.class);
  Mockito.when(sessionRequest1.getAttachment()).thenReturn("somehost");
  Mockito.when(sessionRequest1.getSession()).thenReturn(iosession1);
  IOSession iosession2=Mockito.mock(IOSession.class);
  SessionRequest sessionRequest2=Mockito.mock(SessionRequest.class);
  Mockito.when(sessionRequest2.getAttachment()).thenReturn("otherhost");
  Mockito.when(sessionRequest2.getSession()).thenReturn(iosession2);
  ConnectingIOReactor ioreactor=Mockito.mock(ConnectingIOReactor.class);
  Mockito.when(ioreactor.connect(Mockito.eq(InetSocketAddress.createUnresolved("somehost",80)),Mockito.any(SocketAddress.class),Mockito.any(),Mockito.any(SessionRequestCallback.class))).thenReturn(sessionRequest1);
  Mockito.when(ioreactor.connect(Mockito.eq(InetSocketAddress.createUnresolved("otherhost",80)),Mockito.any(SocketAddress.class),Mockito.any(),Mockito.any(SessionRequestCallback.class))).thenReturn(sessionRequest2);
  LocalSessionPool pool=new LocalSessionPool(ioreactor,2,10);
  pool.setMaxPerRoute("somehost",2);
  pool.setMaxPerRoute("otherhost",1);
  pool.setMaxTotal(3);
  Future<LocalPoolEntry> future1=pool.lease("somehost",null);
  pool.requestCompleted(sessionRequest1);
  Future<LocalPoolEntry> future2=pool.lease("somehost",null);
  pool.requestCompleted(sessionRequest1);
  Future<LocalPoolEntry> future3=pool.lease("otherhost",null);
  pool.requestCompleted(sessionRequest2);
  LocalPoolEntry entry1=future1.get();
  Assert.assertNotNull(entry1);
  LocalPoolEntry entry2=future2.get();
  Assert.assertNotNull(entry2);
  LocalPoolEntry entry3=future3.get();
  Assert.assertNotNull(entry3);
  pool.release(entry1,true);
  pool.release(entry2,true);
  pool.release(entry3,true);
  PoolStats totals=pool.getTotalStats();
  Assert.assertEquals(3,totals.getAvailable());
  Assert.assertEquals(0,totals.getLeased());
  Assert.assertEquals(0,totals.getPending());
  Future<LocalPoolEntry> future4=pool.lease("somehost",null);
  Future<LocalPoolEntry> future5=pool.lease("somehost",null);
  Future<LocalPoolEntry> future6=pool.lease("otherhost",null);
  Future<LocalPoolEntry> future7=pool.lease("somehost",null);
  Future<LocalPoolEntry> future8=pool.lease("somehost",null);
  Future<LocalPoolEntry> future9=pool.lease("otherhost",null);
  Assert.assertTrue(future4.isDone());
  LocalPoolEntry entry4=future4.get();
  Assert.assertNotNull(entry4);
  Assert.assertTrue(future5.isDone());
  LocalPoolEntry entry5=future5.get();
  Assert.assertNotNull(entry5);
  Assert.assertTrue(future6.isDone());
  LocalPoolEntry entry6=future6.get();
  Assert.assertNotNull(entry6);
  Assert.assertFalse(future7.isDone());
  Assert.assertFalse(future8.isDone());
  Assert.assertFalse(future9.isDone());
  Mockito.verify(ioreactor,Mockito.times(3)).connect(Mockito.any(SocketAddress.class),Mockito.any(SocketAddress.class),Mockito.any(),Mockito.any(SessionRequestCallback.class));
  pool.release(entry4,true);
  pool.release(entry5,false);
  pool.release(entry6,true);
  Assert.assertTrue(future7.isDone());
  Assert.assertFalse(future8.isDone());
  Assert.assertTrue(future9.isDone());
  Mockito.verify(ioreactor,Mockito.times(4)).connect(Mockito.any(SocketAddress.class),Mockito.any(SocketAddress.class),Mockito.any(),Mockito.any(SessionRequestCallback.class));
}
