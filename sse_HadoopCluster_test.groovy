import ru.neoflex.meta.utils.Context
def session = Context.current.txSession
def entity = session.createQuery("from sse.HadoopCluster where name = :name").setParameter("name", "test").uniqueResult() 
entity.livyServer = session.createQuery("from rt.LivyServer where name = :name").setParameter("name", "ih921081.vds.myihor.ru").uniqueResult()
entity.hiveConnection = session.createQuery("from rt.JdbcConnection where name = :name").setParameter("name", "hiveihor").uniqueResult()
entity.referenceConnection = session.createQuery("from rt.JdbcConnection where name = :name").setParameter("name", "myihor_phoenix").uniqueResult()
entity.project = null
Context.current.commit()
