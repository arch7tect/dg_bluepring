import ru.neoflex.meta.utils.Context
def session = Context.current.txSession
def entity = session.createQuery("from rt.JdbcConnection where name = :name").setParameter("name", "hiveihor").uniqueResult() 
entity.project = session.createQuery("from etl.Project where name = :name").setParameter("name", "new_nr_service").uniqueResult()
Context.current.commit()
