import React, { useState, useContext, useEffect } from "react";
import { View, Text, SafeAreaView, VirtualizedList, TouchableOpacity, Image, ScrollView } from "react-native";
import styles from "./style";
import { AuthContext } from "../../context/auth";
import blogFetch from "../../axios/config";
import { Buffer } from "buffer";

export default function Info() {
    const { idCadastro, nome } = useContext(AuthContext);
    //const [idCarteira, setIdCarteira] = useState();
    const [imagem, setImagem] = useState ();
    const [dados, setDados] = useState();
    const [loading, setLoading] = useState(true);
    const [loadingImg, setLoadingImg] = useState(true);
    const [error, setError] = useState(false);
    const [errorImg, setErrorImg] = useState(false);

    
    /*
    async function getIdCarteira(){
        try {
            const response = await blogFetch.get(`/carteira-vacina/listar-id/${idCadastro}`);
            const data = (response.data);
            const carteira = data.id_carteiraVacina;
            setIdCarteira(carteira);
            getDados();
            //console.log(data);
        } catch (error) {
            const cadastro = "idCadastro";
            const formData = new FormData();
            formData.append('id_cadastro', cadastro);
            //formData.append('foto', null);
            await blogFetch.post("/carteira-vacina/cadastrar", formData);
            getIdCarteira();
            //console.log(error, formData);
        }
    }*/

    async function getDados(){
        try {
            const response = await blogFetch.get(`vacinas-tomadas/por-carteira/${idCadastro}`);
            setDados(response.data);
        } catch (error) {
            console.log(error);
            setError(true);
        } finally {
            setLoading(false);
        }
    }
  
    const fetchImage = async () => {
        try {
          const response = await blogFetch.get(`/carteira-vacina/foto/${idCadastro}`, {
            responseType: 'arraybuffer',
          });
          const binaryString = Buffer.from(response.data, 'binary').toString('base64');
          return binaryString;
        } catch (error) {
          console.error("Erro ao buscar a foto:", error);
          setErrorImg(true);
          throw error;
        }
      };
    
      const binaryToBase64 = (binary) => {
        return `data:image/jpeg;base64,${binary}`;
      };
    
      const loadImage = async () => {
        try {
          const binaryString = await fetchImage();
          const base64String = binaryToBase64(binaryString);
          setImagem(base64String);
          setLoadingImg(false);
          //console.log(base64String);
        } catch (error) {
            console.error(error);
        }
      };
    /*
    const loadImage = async () => {
        const response = await blogFetch.get(`/carteira-vacina/foto/${idCadastro}`);
        const data = response.data;
        console.log(data);
    }*/

    useEffect(() => {
        getDados();
        loadImage();
    }, []);

    const getVacinas = (dados, index) => dados[index];
    const getVacinasCount = (dados) => dados.length;

    const vacinasTomadas = ({ item }) => (
        <View style={styles.divconteiner}>
            <View style={styles.DivdeBaixo}>
                <Text>Nome da vacina: {item.vacina} </Text>
                <Text>Quantidade de dose tomada: {item.doseTomadas} </Text>
                <Text>Data da vacinação: {item.dataVacinaTomda} </Text>
                <Text>Descrição da vacina: {item.descricao} </Text>
            </View>
        </View>
    );

    return (
        <View style={styles.Tela1}>
            <View style={styles.Tela}>

                <View style={styles.Divdecima}>
                    <View style={styles.nomeIdade}>
                        <Text style={styles.Txt}>nome: {nome} </Text>
                    </View>
                    <View style={styles.imgdePerfil}>
                    {loadingImg ? (
                        <Text>Procurando imagem</Text>
                    ) : errorImg ? (
                        <Text>Foto não cadastrada</Text>
                    ) : (                     
                        <Image
                            source={{ uri: imagem }}
                            //source={{ uri: "https://s2-techtudo.glbimg.com/SSAPhiaAy_zLTOu3Tr3ZKu2H5vg=/0x0:1024x609/888x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_08fbf48bc0524877943fe86e43087e7a/internal_photos/bs/2022/c/u/15eppqSmeTdHkoAKM0Uw/dall-e-2.jpg" }}
                            style={styles.image}
                        />                        
                    )}
                    </View>
                </View>
                <View style={styles.DivdoMeio}>
                <Text style={styles.textMeio}>
                    adic. foto
                </Text>
                </View>


                <SafeAreaView style={styles.vacinas}>
                    {loading ? (
                        <Text>Procurando informações das vacinas</Text>
                    ) : error ? (
                        <Text style={styles.textError}>Sem vacinas cadastradas</Text>
                    ) : (
                            <VirtualizedList
                                data={dados}
                                initialNumToRender={100}
                                renderItem={vacinasTomadas}
                                keyExtractor={(vacinas) => vacinas.id_listavacina.toString()}
                                getItem={getVacinas}
                                getItemCount={getVacinasCount}
                            />
                        )}
                </SafeAreaView> 

            </View>
        </View>
    )
}
