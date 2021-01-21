/** 
 * Tests that we can write out an edit, close, and then read it back in again.
 * @throws IOException
 */
public void testEditAdd() throws IOException {
  final int COL_COUNT=10;
  final byte[] tableName=Bytes.toBytes("tablename");
  final byte[] row=Bytes.toBytes("row");
  HLog.Reader reader=null;
  HLog log=new HLog(fs,dir,this.oldLogDir,this.conf,null);
  try {
    long timestamp=System.currentTimeMillis();
    WALEdit cols=new WALEdit();
    for (int i=0; i < COL_COUNT; i++) {
      cols.add(new KeyValue(row,Bytes.toBytes("column"),Bytes.toBytes(Integer.toString(i)),timestamp,new byte[]{(byte)(i + '0')}));
    }
    HRegionInfo info=new HRegionInfo(new HTableDescriptor(tableName),row,Bytes.toBytes(Bytes.toString(row) + "1"),false);
    final byte[] regionName=info.getRegionName();
    log.append(info,tableName,cols,System.currentTimeMillis());
    long logSeqId=log.startCacheFlush();
    log.completeCacheFlush(regionName,tableName,logSeqId,info.isMetaRegion());
    log.close();
    Path filename=log.computeFilename(log.getFilenum());
    log=null;
    reader=HLog.getReader(fs,filename,conf);
    for (int i=0; i < 1; i++) {
      HLog.Entry entry=reader.next(null);
      if (entry == null)       break;
      HLogKey key=entry.getKey();
      WALEdit val=entry.getEdit();
      assertTrue(Bytes.equals(regionName,key.getRegionName()));
      assertTrue(Bytes.equals(tableName,key.getTablename()));
      KeyValue kv=val.getKeyValues().get(0);
      assertTrue(Bytes.equals(row,kv.getRow()));
      assertEquals((byte)(i + '0'),kv.getValue()[0]);
      System.out.println(key + " " + val);
    }
    HLog.Entry entry=null;
    while ((entry=reader.next(null)) != null) {
      HLogKey key=entry.getKey();
      WALEdit val=entry.getEdit();
      assertTrue(Bytes.equals(regionName,key.getRegionName()));
      assertTrue(Bytes.equals(tableName,key.getTablename()));
      KeyValue kv=val.getKeyValues().get(0);
      assertTrue(Bytes.equals(HLog.METAROW,kv.getRow()));
      assertTrue(Bytes.equals(HLog.METAFAMILY,kv.getFamily()));
      assertEquals(0,Bytes.compareTo(HLog.COMPLETE_CACHE_FLUSH,val.getKeyValues().get(0).getValue()));
      System.out.println(key + " " + val);
    }
  }
  finally {
    if (log != null) {
      log.closeAndDelete();
    }
    if (reader != null) {
      reader.close();
    }
  }
}
