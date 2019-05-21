import ru.neoflex.meta.utils.Context
def session = Context.current.txSession
def entity = session.createQuery("from rt.Deployment where name = :name").setParameter("name", "DatagramOnLocal").uniqueResult() 
entity.project = session.createQuery("from etl.Project where name = :name").setParameter("name", "blueprint_git").uniqueResult()
entity.connection = session.createQuery("from rt.JdbcConnection where name = :name").setParameter("name", "PostgresDatagram").uniqueResult()
entity.softwareSystem = session.createQuery("from rt.SoftwareSystem where name = :name").setParameter("name", "datagram").uniqueResult()
Context.current.commit()
