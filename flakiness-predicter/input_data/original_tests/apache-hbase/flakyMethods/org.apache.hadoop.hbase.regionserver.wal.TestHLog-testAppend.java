/** 
 * @throws IOException
 */
public void testAppend() throws IOException {
  final int COL_COUNT=10;
  final byte[] tableName=Bytes.toBytes("tablename");
  final byte[] row=Bytes.toBytes("row");
  this.conf.setBoolean("dfs.support.append",true);
  Reader reader=null;
  HLog log=new HLog(this.fs,dir,this.oldLogDir,this.conf,null);
  try {
    long timestamp=System.currentTimeMillis();
    WALEdit cols=new WALEdit();
    for (int i=0; i < COL_COUNT; i++) {
      cols.add(new KeyValue(row,Bytes.toBytes("column"),Bytes.toBytes(Integer.toString(i)),timestamp,new byte[]{(byte)(i + '0')}));
    }
    HRegionInfo hri=new HRegionInfo(new HTableDescriptor(tableName),HConstants.EMPTY_START_ROW,HConstants.EMPTY_END_ROW);
    log.append(hri,tableName,cols,System.currentTimeMillis());
    long logSeqId=log.startCacheFlush();
    log.completeCacheFlush(hri.getRegionName(),tableName,logSeqId,false);
    log.close();
    Path filename=log.computeFilename(log.getFilenum());
    log=null;
    reader=HLog.getReader(fs,filename,conf);
    HLog.Entry entry=reader.next();
    assertEquals(COL_COUNT,entry.getEdit().size());
    int idx=0;
    for (    KeyValue val : entry.getEdit().getKeyValues()) {
      assertTrue(Bytes.equals(hri.getRegionName(),entry.getKey().getRegionName()));
      assertTrue(Bytes.equals(tableName,entry.getKey().getTablename()));
      assertTrue(Bytes.equals(row,val.getRow()));
      assertEquals((byte)(idx + '0'),val.getValue()[0]);
      System.out.println(entry.getKey() + " " + val);
      idx++;
    }
    entry=reader.next();
    assertEquals(1,entry.getEdit().size());
    for (    KeyValue val : entry.getEdit().getKeyValues()) {
      assertTrue(Bytes.equals(hri.getRegionName(),entry.getKey().getRegionName()));
      assertTrue(Bytes.equals(tableName,entry.getKey().getTablename()));
      assertTrue(Bytes.equals(HLog.METAROW,val.getRow()));
      assertTrue(Bytes.equals(HLog.METAFAMILY,val.getFamily()));
      assertEquals(0,Bytes.compareTo(HLog.COMPLETE_CACHE_FLUSH,val.getValue()));
      System.out.println(entry.getKey() + " " + val);
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
