import ru.neoflex.meta.utils.Context
def session = Context.current.txSession
def entity = session.createQuery("from sse.HadoopCluster where name = :name").setParameter("name", "default_cluster").uniqueResult() 
entity.livyServer = session.createQuery("from rt.LivyServer where name = :name").setParameter("name", "default_livy_server").uniqueResult()
entity.hiveConnection = session.createQuery("from rt.JdbcConnection where name = :name").setParameter("name", "default_jdbc").uniqueResult()
entity.referenceConnection = session.createQuery("from rt.JdbcConnection where name = :name").setParameter("name", "default_jdbc").uniqueResult()
entity.project = null
Context.current.commit()
