import ru.neoflex.meta.utils.Context
def session = Context.current.txSession
def entity = session.createQuery("from rt.JdbcConnection where name = :name").setParameter("name", "default_jdbc").uniqueResult() 
entity.project = session.createQuery("from etl.Project where name = :name").setParameter("name", "sandbox").uniqueResult()
Context.current.commit()
