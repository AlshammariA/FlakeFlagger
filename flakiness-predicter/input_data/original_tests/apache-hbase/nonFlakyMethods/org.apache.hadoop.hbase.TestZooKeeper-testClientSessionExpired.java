/** 
 * See HBASE-1232 and http://wiki.apache.org/hadoop/ZooKeeper/FAQ#4.
 * @throws IOException
 * @throws InterruptedException
 */
@Test public void testClientSessionExpired() throws IOException, InterruptedException {
  new HTable(conf,HConstants.META_TABLE_NAME);
  ZooKeeperWrapper zkw=new ZooKeeperWrapper(conf,EmptyWatcher.instance);
  String quorumServers=zkw.getQuorumServers();
  int sessionTimeout=5 * 1000;
  HConnection connection=HConnectionManager.getConnection(conf);
  ZooKeeperWrapper connectionZK=connection.getZooKeeperWrapper();
  long sessionID=connectionZK.getSessionID();
  byte[] password=connectionZK.getSessionPassword();
  ZooKeeper zk=new ZooKeeper(quorumServers,sessionTimeout,EmptyWatcher.instance,sessionID,password);
  zk.close();
  Thread.sleep(sessionTimeout * 3L);
  System.err.println("ZooKeeper should have timed out");
  connection.relocateRegion(HConstants.ROOT_TABLE_NAME,HConstants.EMPTY_BYTE_ARRAY);
}
