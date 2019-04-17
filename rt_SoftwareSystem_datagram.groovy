import ru.neoflex.meta.utils.Context
def session = Context.current.txSession
def entity = session.createQuery("from rt.SoftwareSystem where name = :name").setParameter("name", "datagram").uniqueResult() 
entity.project = session.createQuery("from etl.Project where name = :name").setParameter("name", "sandbox").uniqueResult()
entity.scheme = session.createQuery("from rel.Scheme where name = :name").setParameter("name", "datagram").uniqueResult()
entity.defaultDeployment = session.createQuery("from rt.Deployment where name = :name").setParameter("name", "DatagramOnLocal").uniqueResult()
Context.current.commit()
