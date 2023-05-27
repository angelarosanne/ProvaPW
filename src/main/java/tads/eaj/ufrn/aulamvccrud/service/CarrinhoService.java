//package tads.eaj.ufrn.aulamvccrud.service;
//
//import tads.eaj.ufrn.aulamvccrud.model.Produto;
//import tads.eaj.ufrn.aulamvccrud.repository.CarrinhoRepository;
//import tads.eaj.ufrn.aulamvccrud.repository.ProdutoRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//public class CarrinhoService {
//
//    private CarrinhoRepository repository;
//
//    public CarrinhoService(CarrinhoRepository repository) {
//        this.repository = repository;
//    }
//
//    public void save(Produto p){
////        p.tituloMaiusculo();
//        repository.save(p);
//    }
//
//    public List<Produto> findAll(){
//        return repository.findAll();
//    }
//
//    public Optional<Produto> findById(String id){
//        return repository.findById(id);
//    }
//
//    public void delete(String id){
//        repository.deleteById(id);
//    }
//}
